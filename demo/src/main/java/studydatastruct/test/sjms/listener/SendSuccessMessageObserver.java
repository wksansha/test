package studydatastruct.test.sjms.listener;

/**
 * @author wangkai
 * @create 2021/6/3
 */
public class SendSuccessMessageObserver implements Observer {

    @Override
    public void update(String message) {
        // 处理业务逻辑
        System.out.println("注册成功");
    }

    public static void main(String[] args) {
        // 假设用户注册成功直接通知观察者，改干自己的事情了
        ConcreteSubject subject = buildSubject();
        subject.notifyObservers("");
    }

    private static ConcreteSubject buildSubject() {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new SendSuccessMessageObserver());
        subject.attach(new SendNewPersonCouponObserver());
        return subject;
    }
}

