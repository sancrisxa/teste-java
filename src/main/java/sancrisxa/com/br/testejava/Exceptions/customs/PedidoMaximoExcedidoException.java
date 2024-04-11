package sancrisxa.com.br.testejava.Exceptions.customs;

public class PedidoMaximoExcedidoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PedidoMaximoExcedidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public PedidoMaximoExcedidoException(String message) {
        super(message);
    }
}
