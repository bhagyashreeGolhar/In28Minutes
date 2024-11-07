package Exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28Minutes.RestWebservices.RestWebservices.User.ErrorDetails;
import com.in28Minutes.RestWebservices.RestWebservices.User.UserNotFoundException;

@RestControllerAdvice
public class customisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserNotFoundException.class)
	public  ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex)
	{
		System.out.println("HandleAllExceptioncalled");
		//ErrorDetails errorDetails= new ErrorDetails(request.getDescription(false), ex.getMessage(), LocalDate.now());
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGenericException(String msg)
	{
		return new ResponseEntity<Object>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
