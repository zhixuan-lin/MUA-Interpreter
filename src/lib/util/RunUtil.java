package lib.util;

import lib.List;
import lib.MuaObject;
import lib.Scope;
import lib.operation.OpStop;

import static lib.util.ParserUtil.evalObj;
import static lib.util.ParserUtil.parseExpr;

import java.util.ArrayList;

public class RunUtil {
    public static void runList(Scope scope, List l) throws Exception {
        ArrayList<String> tokens = new ArrayList<>();
        for (MuaObject token : l.getValue()) {
            tokens.add(token.toString());
        }
        try {
            ArrayList<ArrayList<String>> exprs = parseExpr(tokens, scope);
            for (ArrayList<String> expr: exprs) {
                 evalObj(expr, scope);
            }
        }
        catch (OpStop.StopSignal s) {
            throw s;
        }
    }
}
