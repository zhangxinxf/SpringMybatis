package com.zx.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = { "conf/applicationContext.xml" })
public class SpringTestUtils extends AbstractTransactionalJUnit4SpringContextTests {
  
}
