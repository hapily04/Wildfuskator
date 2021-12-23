package me.hapily.addons.wildfuskator.elements.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.hapily.addons.wildfuskator.util.Obfuscator;
import org.bukkit.event.Event;

public class EffObfuscate extends Effect {

    static{
        Skript.registerEffect(EffObfuscate.class, "obfuscate file %string% to file %string% with power %number%");
    }

    private Expression<String> from;
    private Expression<String> to;
    private Expression<Number> power;

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.from = (Expression<String>) expressions[0];
        this.to = (Expression<String>) expressions[1];
        this.power = (Expression<Number>) expressions[2];
        return true;
    }

    protected void execute(Event event) {
        String fro = from.getSingle(event);
        String t = to.getSingle(event);
        Number po = power.getSingle(event);
        if (fro == null || t == null || po == null) {
            return;
        }
        try {
            Obfuscator.to(fro, t, po.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }
}
