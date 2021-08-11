package studydatastruct.test.sjms.listener;

/**
 * @author 44803
 * @title: Subject
 * @projectName hello-world
 * @description: TODO
 * @date 2021/6/314:23
 */
public interface Subject {
    // 添加订阅关系
    void attach(Observer observer);
    // 移除订阅关系
    void detach(Observer observer);
    // 通知订阅者
    void notifyObservers(String message);
}