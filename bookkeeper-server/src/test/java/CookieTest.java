import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.bookkeeper.bookie.Cookie.*;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.bookkeeper.bookie.BookieException;
import org.apache.bookkeeper.bookie.BookieImpl;
import org.apache.bookkeeper.bookie.Cookie;
import org.apache.bookkeeper.conf.ServerConfiguration;
import org.apache.bookkeeper.discover.RegistrationManager;
import org.apache.bookkeeper.net.BookieId;
import org.apache.bookkeeper.versioning.Version;


import org.apache.bookkeeper.versioning.Versioned;
import org.eclipse.jetty.server.Server;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
class CookieTest {

	private static RegistrationManager rm;
	private static ServerConfiguration conf;
	private static Version version;

	@Parameterized.Parameters
	public static Collection<Object[]> configure() throws Exception {
		return Arrays.asList(new Object[][]{
				{rm, conf, version}
		});
	}

	public CookieTest(RegistrationManager rm, ServerConfiguration conf, Version version) {
		this.rm = rm;
		this.conf = conf;
		this.version = version;


	}

	@Test
	void testWriteReadToRegistrationManager() throws BookieException {

		Versioned ter3 = readFromRegistrationManager(rm, conf);

		// creo un versioned e lo inserisco nel registro e poi vedo se quella che legge è uguale a quella creata
		byte[] data = toString().getBytes(UTF_8);
		Versioned ter1 = new Versioned<>(data, version);

		writeToRegistrationManager(rm, conf, version);
		Versioned ter2 = readFromRegistrationManager(rm, conf);
		assertEquals(ter1, ter2);
		assertNotEquals(ter3, ter2);
		assertTrue(ter2 != null);


	}

	@Test
	void testDeleteFromRegistrationManager() {
		try {
			Versioned versioned = readFromRegistrationManager(rm, conf);
			if (versioned == null) {
				assertEquals(readFromRegistrationManager(rm, conf), null);
				writeToRegistrationManager(rm, conf, version);
				assertTrue(readFromRegistrationManager(rm, conf) != null);
				deleteFromRegistrationManager(rm, conf, version);
				assertTrue(readFromRegistrationManager(rm, conf) == null);
			} else {
				Versioned versioned1 = readFromRegistrationManager(rm, conf);
				deleteFromRegistrationManager(rm, conf, version);
				assertNotEquals(versioned1, readFromRegistrationManager(rm, conf));
				assertNotEquals(readFromRegistrationManager(rm, conf), null);
			}

		} catch (BookieException bE) {

		}
	}
}

