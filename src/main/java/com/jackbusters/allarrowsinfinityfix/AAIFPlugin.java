package com.jackbusters.allarrowsinfinityfix;

import com.jackbusters.allarrowsinfinityfix.allarrowsinfinityfix.Tags;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import zone.rong.mixinbooter.IEarlyMixinLoader;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@IFMLLoadingPlugin.Name(Tags.MOD_NAME)
public class AAIFPlugin implements IFMLLoadingPlugin, IEarlyMixinLoader {

    public static File coreModLocation;

    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixins.allarrowsinfinityfix.json");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return "com.jackbusters.allarrowsinfinityfix.AllArrowsInfinityFix";
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        coreModLocation = (File) data.get("coremodlocation");
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
