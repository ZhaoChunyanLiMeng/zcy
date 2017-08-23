package org.lanqiao.algo.datastructure;
/**
 * 表示一个操作，该操作接受单个输入参数，不返回结果。 与大多数其他功能接口不同，@code使用者将通过副作用进行操作，
 * 这是一个接口，T----操作的输入类型
 */
import java.util.Objects;

public interface Consumer<T> {
	void accept(T t);
	default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}
