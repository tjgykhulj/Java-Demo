package demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import demo.BaseDemo;

// Table
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DBTable {
	public String name() default "";
}

// 属性
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Constraints {
	boolean primaryKey() default false;

	boolean allowNull() default true;

	boolean unique() default false;
}

// ------------------------基本类型-----------------//
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SQLString {
	int value() default 0;

	String name() default "";

	Constraints constraints() default @Constraints;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SQLInteger {
	String name() default "";

	Constraints constraints() default @Constraints;
}

// -----------------------举例-------------//
@DBTable(name = "USER")
class User {
	@SQLString(30)
	String username;
	@SQLInteger(constraints = @Constraints(unique = true, primaryKey = true))
	Integer id;

	public String getUsername() {
		return username;
	}

	public Integer getId() {
		return id;
	}
}

@DBTable(name = "BOOK")
class Book {
	@SQLString(30)
	String name;
	@SQLInteger(constraints = @Constraints(unique = true, primaryKey = true))
	Integer id;
	@SQLInteger
	Integer price;

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public Integer getPrice() {
		return price;
	}
}

public class Test0 extends BaseDemo {

	public static String getConstraints(Constraints con) {
		String res = "";
		if (!con.allowNull())
			res += " NOT NULL";
		if (con.primaryKey())
			res += " PRIMARY KEY";
		if (con.unique())
			res += " UNIQUE";
		return res;
	}

	public static String sqlCreateTable(String classname)
			throws ClassNotFoundException {
		Class<?> cl = Class.forName(classname);
		DBTable table = cl.getAnnotation(DBTable.class);

		List<String> colDef = new ArrayList<>();
		for (Field field : cl.getDeclaredFields()) {
			Annotation[] ano = field.getDeclaredAnnotations();
			if (ano.length == 0)
				continue;
			if (ano[0] instanceof SQLInteger) {
				SQLInteger sInt = (SQLInteger) ano[0];
				colDef.add(String.format("%s INT", field.getName()
						.toUpperCase())
						+ getConstraints(sInt.constraints()));
			}
			if (ano[0] instanceof SQLString) {
				SQLString sStr = (SQLString) ano[0];
				colDef.add(String.format("%s VARCHAR(%d)", field.getName()
						.toUpperCase(), sStr.value())
						+ getConstraints(sStr.constraints()));
			}
		}
		StringBuffer tableCreate = new StringBuffer(String.format(
				"CREATE TABLE %s(", table.name()));
		for (String s : colDef) {
			tableCreate.append("\n          ");
			tableCreate.append(s);
			tableCreate.append(',');
		}
		tableCreate.setCharAt(tableCreate.length() - 1, ')');
		tableCreate.append(';');
		return tableCreate.toString();
	}

	public static void main(String[] args) throws ClassNotFoundException {
		println(sqlCreateTable("demo.annotation.User"));
		println(sqlCreateTable("demo.annotation.Book"));
	}

}