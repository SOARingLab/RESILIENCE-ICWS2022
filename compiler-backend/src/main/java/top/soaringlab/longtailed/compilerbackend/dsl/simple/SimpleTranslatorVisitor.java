package top.soaringlab.longtailed.compilerbackend.dsl.simple;

public class SimpleTranslatorVisitor extends SimpleBaseVisitor<String> {
    @Override
    public String visitInputs(SimpleParser.InputsContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();
        for (SimpleParser.InputContext inputContext : ctx.input()) {
            stringBuilder.append(visit(inputContext));
        }
        return stringBuilder.toString();
    }

    @Override
    public String visitInput(SimpleParser.InputContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("if (\n");
        for (SimpleParser.ConditionContext conditionContext : ctx.condition()) {
            stringBuilder.append("    ").append(visit(conditionContext)).append("\n");
        }
        stringBuilder.append(") {\n");
        for (SimpleParser.ActionContext actionContext : ctx.action()) {
            stringBuilder.append("    ").append(visit(actionContext)).append("\n");
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    @Override
    public String visitCondition(SimpleParser.ConditionContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();
        if (ctx.logical.getText().equals("AND")) {
            stringBuilder.append("&& ");
        } else if (ctx.logical.getText().equals("OR")) {
            stringBuilder.append("|| ");
        }
        stringBuilder.append(ctx.operand1.getText()).append(" ").append(ctx.operator.getText()).append(" ").append(ctx.operand2.getText());
        return stringBuilder.toString();
    }

    @Override
    public String visitAction(SimpleParser.ActionContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("execution.setVariable(\"").append(ctx.operand1.getText()).append("\", ").append(ctx.operand2.getText()).append(");");
        return stringBuilder.toString();
    }
}
