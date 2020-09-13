package okw.exceptions;


public class OKWSeIFrameNotFoundException extends RuntimeException
{

	/** \~german
	 *  Exception wird ausgelöst, wenn der Kontext nicht auf ein iFrame gesetzt werden kann.
	 *  
	 *  \~english
	 *  Exception is thrown if the context cannot be set to an iFrame.
	 *  
	 *  \~
	 *  
	 *  \author Zoltán Hrabovszki
	 *  \date 2020.09.12
	 */
	private static final long serialVersionUID = -5806763576903492716L;

	public OKWSeIFrameNotFoundException()
	{
		super();
	}

	public OKWSeIFrameNotFoundException(String message)
	{
		super(message);
	}	
}
