package larvae.jboss.mgmt;

import java.io.File;
import java.io.IOException;

import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.client.helpers.standalone.DeploymentAction;
import org.jboss.as.controller.client.helpers.standalone.DeploymentPlan;
import org.jboss.as.controller.client.helpers.standalone.DeploymentPlanBuilder;
import org.jboss.as.controller.client.helpers.standalone.ServerDeploymentActionResult;
import org.jboss.as.controller.client.helpers.standalone.ServerDeploymentManager;
import org.jboss.as.controller.client.helpers.standalone.ServerDeploymentPlanResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fj.F;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Specify archive path and command (deploy | redeploy | undeploy).");
            return;
        }
        LOGGER.info("args: {}", (Object) args);
        File file = new File(args[0]);
        String command = args[1];
        switch (command) {
        case "deploy":
            new Main().run(deploy(file));
            break;
        case "redeploy":
            new Main().run(redeploy(file));
            break;
        case "undeploy":
            new Main().run(undeploy(file));
            break;
        default:
            break;
        }
    }

    public void run(F<DeploymentPlanBuilder, DeploymentPlan> builder) {
        try (ModelControllerClient client = ModelControllerClient.Factory.create("localhost", 9999)) {
            ServerDeploymentManager manager = ServerDeploymentManager.Factory.create(client);
            DeploymentPlan plan = builder.f(manager.newDeploymentPlan());
            ServerDeploymentPlanResult planResult = manager.execute(plan).get();
            for (DeploymentAction action : plan.getDeploymentActions()) {
                ServerDeploymentActionResult actionResult = planResult.getDeploymentActionResult(action.getId());
                LOGGER.info("{} => {}", action.getType(), actionResult.getResult());
                if (actionResult.getDeploymentException() != null) throw actionResult.getDeploymentException();
            }
        } catch (Throwable t) {
            LOGGER.error(t.getMessage(), t);
        }
    }

    public static F<DeploymentPlanBuilder, DeploymentPlan> deploy(final File file) {
        return new F<DeploymentPlanBuilder, DeploymentPlan>() {
            @Override
            public DeploymentPlan f(DeploymentPlanBuilder builder) {
                try {
                    return builder.add(file).andDeploy().build();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static F<DeploymentPlanBuilder, DeploymentPlan> redeploy(final File file) {
        return new F<DeploymentPlanBuilder, DeploymentPlan>() {
            @Override
            public DeploymentPlan f(DeploymentPlanBuilder builder) {
                try {
                    return builder.replace(file).redeploy(file.getName()).build();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static F<DeploymentPlanBuilder, DeploymentPlan> undeploy(final File file) {
        return new F<DeploymentPlanBuilder, DeploymentPlan>() {
            @Override
            public DeploymentPlan f(DeploymentPlanBuilder builder) {
                return builder.undeploy(file.getName()).andRemoveUndeployed().build();
            }
        };
    }

}
