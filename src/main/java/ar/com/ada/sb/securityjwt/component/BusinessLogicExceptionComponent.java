package ar.com.ada.sb.securityjwt.component;

import ar.com.ada.sb.securityjwt.exception.ApiEntityError;
import ar.com.ada.sb.securityjwt.exception.BusinessLogicException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component("businessLogicExceptionComponent")
public class BusinessLogicExceptionComponent {

    public void throwExceptionEntityNotFound(String entityName, Long id) {
        ApiEntityError apiEntityError = new ApiEntityError(
                entityName,
                "Not found",
                "The " + entityName + " with id '" + id + "' does not exist"
        );

        throw new BusinessLogicException(
                entityName + " does not exist",
                HttpStatus.NOT_FOUND,
                apiEntityError
        );
    }
}
