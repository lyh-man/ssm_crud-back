# ssm_crud
## 一、概要

（1）ssm进行crud操作的小案例，包括环境配置、UI界面以及相关的crud的实现

（2）涉及mysql，vue，bootstrap，ssm。


## 二、相关准备工作
### 1、mysql 数据库表：
#### 准备工作（建表）：
```
emp
	-- 创建一个 emp 表，其中 id 为主键且自增。
	CREATE TABLE emp(
		id int primary key auto_increment,
		name varchar(50),
		salary double,
		age int,
		email varchar(50)
	);

dept
	-- 创建一个 dept 表，其中 deptId 为自增主键
	CREATE TABLE dept(
		deptId INT(11) PRIMARY KEY AUTO_INCREMENT,
		deptName VARCHAR(255)
	);
	
	-- 给 emp 表增加一个列
	ALTER TABLE emp ADD COLUMN deptId INT(11);
	
	-- 并将 emp 中该列作为外键关联到 dept 的主键
	ALTER TABLE emp ADD CONSTRAINT fk_emp_dept FOREIGN KEY(deptId) REFERENCES dept(deptId);
```
			
		
#### 准备工作（插数据）：
```
dept
	INSERT INTO dept(deptId, deptName) VALUES(1, '开发部');
	INSERT INTO dept(deptId, deptName) VALUES(2, '测试部');
	INSERT INTO dept(deptId, deptName) VALUES(3, '产品部');

emp(id自增，给其插个 null 即可)
	INSERT INTO emp(id, name, salary, age, email, deptId) VALUES(null, 'tom', '8000', 23, 'tom@163.com', 1);
	INSERT INTO emp(id, name, salary, age, email, deptId) VALUES(null, 'jarry', '7000', 23, 'jarry@163.com', 2);
	INSERT INTO emp(id, name, salary, age, email, deptId) VALUES(null, 'rick', '9000', 23, 'rick@163.com', 3);
	INSERT INTO emp(id, name, salary, age, email, deptId) VALUES(null, 'rose', '11000', 23, 'rose@163.com', 3);
	INSERT INTO emp(id, name, salary, age, email, deptId) VALUES(null, 'tim', '3300', 23, 'tim@163.com', 2);
	INSERT INTO emp(id, name, salary, age, email, deptId) VALUES(null, 'silla', '9100', 23, 'silla@163.com', 1);
	INSERT INTO emp(id, name, salary, age, email, deptId) VALUES(null, 'jack', '10000', 23, 'jack@163.com', 1);
	INSERT INTO emp(id, name, salary, age, email, deptId) VALUES(null, 'lisa', '6000', 23, 'lisa@163.com', 2);
	INSERT INTO emp(id, name, salary, age, email, deptId) VALUES(null, 'mina', '9000', 23, 'mina@163.com', 2);
```

### 2、前台展示  bootstrap + jQuery + vue
	
	页面 数据布局
	id	name 	salary    age  email   deptName
	
	
### 3、后台接口 SSM
```
实现增删改查
	查所有员工： 两表联合查询
		SELECT e.id AS id, e.name AS name, e.salary AS salary, e.age AS age, e.email AS email, d.deptName AS deptName
		  FROM emp e
		  LEFT JOIN dept d
		    ON e.deptId = d.deptId
		 ORDER BY e.id;
 	
	查单个员工：
		SELECT e.id AS id, e.name AS name, e.salary AS salary, e.age AS age, e.email AS email, d.deptName AS deptName
		  FROM emp e
		  LEFT JOIN dept d
		    ON e.deptId = d.deptId
		 WHERE e.id = 1
		 ORDER BY e.id;

	增： 只增加 emp 表
		INSERT INTO emp(id, name, salary, age, email, deptId) VALUES(null, 'tom', '8000', 23, '13865561381@163.com', 1);

	删： 只删除 emp 表
		DELETE FROM emp WHERE emp.id = 1;

	改： 只修改 emp 表
		UPDATE emp SET name = 'joker' WHERE id = 2;


	批量删：只删除 emp 表。
```
