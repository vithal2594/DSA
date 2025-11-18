// // CustomCheckedException.java
// public class CustomCheckedException extends Exception {
//     private static final int ERROR_CODE = 1001;
    
//     public CustomCheckedException(String message) {
//         super(message);
//     }
    
//     public int getErrorCode() {
//         return ERROR_CODE;
//     }
// }

// // CustomUncheckedException.java
// public class CustomUncheckedException extends RuntimeException {
//     private static final int ERROR_CODE = 1002;
    
//     public CustomUncheckedException(String message) {
//         super(message);
//     }
    
//     public int getErrorCode() {
//         return ERROR_CODE;
//     }
// }

// // GlobalExceptionHandler.java
// @ControllerAdvice
// public class GlobalExceptionHandler {
//     @ExceptionHandler(CustomCheckedException.class)
//     public ResponseEntity<ErrorResponse> handleCustomCheckedException(CustomCheckedException e) {
//         ErrorResponse errorResponse = new ErrorResponse();
//         errorResponse.setError(e.getErrorCode());
//         errorResponse.setMessage(e.getMessage());
//         return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
    
//     @ExceptionHandler(CustomUncheckedException.class)
//     public ResponseEntity<ErrorResponse> handleCustomUncheckedException(CustomUncheckedException e) {
//         ErrorResponse errorResponse = new ErrorResponse();
//         errorResponse.setError(e.getErrorCode());
//         errorResponse.setMessage(e.getMessage());
//         return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
    
//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<ErrorResponse> handleOtherException(Exception e) {
//         ErrorResponse errorResponse = new ErrorResponse();
//         errorResponse.setError(-1);
//         errorResponse.setMessage("An unexpected error occurred");
//         return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
    
//     class ErrorResponse {
//         private int error;
//         private String message;
        
//         // getters and setters
//     }
// }

// // MainController.java
// @RestController
// public class MainController {
//     @RequestMapping("/")
//     public String home() {
//         throw new CustomCheckedException("This is a custom checked exception");
//     }
    
//     @RequestMapping("/unchecked")
//     public String unchecked() {
//         throw new CustomUncheckedException("This is a custom unchecked exception");
//     }
// }