package studydatastruct.test.sjms.listener;

/**
 * @author 44803
 * @title: Observer
 * @projectName hello-world
 * @description: TODO
 * @date 2021/6/314:22
 */
public interface Observer {
    // 处理业务逻辑
    void update(String message);
}
