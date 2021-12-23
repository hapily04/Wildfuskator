package me.hapily.addons.wildfuskator.elements.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.hapily.addons.wildfuskator.util.Loader;
import me.hapily.addons.wildfuskator.util.Obfuscator;
import org.bukkit.event.Event;

import java.io.File;
import java.util.regex.Matcher;

public class EffLoad extends Effect {

    static{
        Skript.registerEffect(EffLoad.class, "load obfuscated file %string% by power %number%");
    }

    private Expression<String> from;
    private Expression<Number> n;

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.from = (Expression<String>) expressions[0];
        this.n = (Expression<Number>) expressions[1];
        return true;
    }

    protected void execute(Event event) {
        String fro = from.getSingle(event);
        Number power = n.getSingle(event);
        if (fro == null || power == null) {
            return;
        }
        String code = "";
        try {
            code = Obfuscator.load(new File(fro.replaceAll("/", Matcher.quoteReplacement(File.separator))), power.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Loader.loadString(code);
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }
}
