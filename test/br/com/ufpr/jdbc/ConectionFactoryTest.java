package br.com.ufpr.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConectionFactoryTest {

	@Test
	public void testGetConnection() {
		MysqlConectionFactory factory = new MysqlConectionFactory();
		assertNotNull(factory.getConnection());
		
	}

}