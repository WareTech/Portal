package com.WareTech.ClubTech.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Database 
{
	final static public String CONFIGURATION_FILENAME = "mybatis-config.xml";
	final static private Database database = new Database();
 	
	static public Database getInstance()
	{
		return database;
	}
	
	protected SqlSessionFactory sqlSessionFactory;

	protected Database()
	{
		try 
		{
			InputStream inputStream = Resources.getResourceAsStream(CONFIGURATION_FILENAME);
			this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}
		catch (Exception database) 
		{
			database.printStackTrace();
		}
	}
	
 	public SqlSessionFactory getSqlSessionFactory()
	{
		return sqlSessionFactory;
	}

} 