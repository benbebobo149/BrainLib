// ResourceNotFoundException.java
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("Resource %s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }
}