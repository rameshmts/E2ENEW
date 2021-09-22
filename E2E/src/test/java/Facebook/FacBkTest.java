package Facebook;
import org.apache.logging.log4j.*;
import org.testng.annotations.Test;

import utilities.base;


public class FacBkTest extends base {

	//public static Logger log = LogManager.getLogger(FacBkTest.class.getName());
	
	@Test
	public void loginfcbk()
	{
		
		log.debug("Application is logged in");
		log.info("Application is naviagaeted");
		log.error("Element is not visible");
		log.fatal("Application is failed");
	}
}
