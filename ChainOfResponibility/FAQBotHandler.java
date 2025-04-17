package ChainOfResponibility;
public class FAQBotHandler extends SupportHandler {
    @Override
    public void handle(String issue) {
        if ("password_reset".equals(issue)) {
            System.out.println("[FAQBot] Handled " + issue);
        } else if (next != null) {
            next.handle(issue);
        } else {
            System.out.println("[FAQBot] Cannot handle " + issue + " — escalate manually");
        }
    }
}