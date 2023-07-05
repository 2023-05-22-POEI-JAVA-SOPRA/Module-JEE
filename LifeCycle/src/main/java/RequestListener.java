import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener{
	
	
	private int counter = 0;
	
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		ServletRequestListener.super.requestInitialized(sre);
		
		counter++;
		System.out.println("Request count :" + counter);
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		ServletRequestListener.super.requestDestroyed(sre);
		System.out.println("In request listener destroy");

	}
}
