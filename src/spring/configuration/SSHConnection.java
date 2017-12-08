package spring.configuration;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SSHConnection {
	
	private final static int LOCAl_PORT = 3307; 
	private final static int REMOTE_PORT = 3306; 
	private final static int SSH_REMOTE_PORT = 22; 
	private final static String SSH_USER = "vcm";
	private final static String SSH_REMOTE_SERVER = "vcm-1338.vm.duke.edu";
	private final static String MYSQL_REMOTE_SERVER = "127.0.0.1";
	
	private Session sesion; //represents each ssh session
	
	public SSHConnection () throws Throwable {
	
	    JSch jsch = null;
	
	    jsch = new JSch();
	    sesion = jsch.getSession(SSH_USER, SSH_REMOTE_SERVER, SSH_REMOTE_PORT);
	    sesion.setPassword("plelebro3e");
	    sesion.connect();
	    sesion.setPortForwardingL(LOCAl_PORT, MYSQL_REMOTE_SERVER, REMOTE_PORT); 
	}
	
	public void closeSSH () {
	    sesion.disconnect();
	}
}
