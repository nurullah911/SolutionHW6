package ChainOfResponibility;

public class SeniorSupportHandler extends SupportHandler {
    @Override
    public void handle(String issue) {
        switch (issue) {
            case "account_ban":
            case "data_loss":
                System.out.println("[SeniorSupport] Handled " + issue);
                break;
            default:
                System.out.println("[SeniorSupport] Cannot handle " + issue + " — escalate manually");
        }
    }
}