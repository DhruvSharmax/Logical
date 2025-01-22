package UdemyJavaFundamentalsTest;

class TransactionProcessingException extends Exception {}
class FinancialTransactionException extends TransactionProcessingException {}

public class ExceptionHierarchy {
    public void doFinancialTransaction() throws RuntimeException {
        try {
            throw new FinancialTransactionException();
        } catch (Exception e) {
            throw  new NullPointerException();
        } finally {
            throw new TransactionProcessingException();

            // why this is an error but its child class throwing error above is not an error ?
            // because child class is surrounded with try catch meaning it is handling its shit on its own
            // but remaining two throw are relying on throws of method signature, NPE is an unchecked exception so it shown no error
            // but TransactionProcessingException is a checked exception coz its inheriting Exception class not RunTimeException
            // meaning it needs to be handled or marked in signature that it throws
        }
    }

    public static void main(String[] args) {
        new ExceptionHierarchy().doFinancialTransaction();
    }
}
