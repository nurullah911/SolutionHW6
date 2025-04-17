package ChainOfResponibility;


public class JuniorSupportHandler extends SupportHandler {
    @Override
    public void handle(String issue) {
        switch (issue) {
            case "refund_request":
            case "billing_issue":
                System.out.println("[JuniorSupport] Handled " + issue);
                break;
            default:
                if (next != null) {
                    next.handle(issue);
                } else {
                    System.out.println("[JuniorSupport] Cannot handle " + issue + " — escalate manually");
                }
        }
    }
}