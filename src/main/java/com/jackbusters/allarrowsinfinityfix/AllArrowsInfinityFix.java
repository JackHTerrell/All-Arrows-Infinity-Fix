package com.jackbusters.allarrowsinfinityfix;

import com.google.common.eventbus.EventBus;
import com.jackbusters.allarrowsinfinityfix.allarrowsinfinityfix.Tags;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;

import java.io.File;

public class AllArrowsInfinityFix extends DummyModContainer {
    public AllArrowsInfinityFix(){
        super(new ModMetadata());
        ModMetadata metadata = this.getMetadata();
        metadata.modId = Tags.MOD_ID;
        metadata.name = Tags.MOD_NAME;
        metadata.description = "AAIF forces the infinity enchantment to work with all arrows.";
        metadata.credits = "CleanroomMC for adding Mixin compatibility to 1.12.2";
        metadata.version = Tags.VERSION;
        metadata.authorList.add("Jackbusters");
        metadata.useDependencyInformation = true;
        ArtifactVersion mixinBooterRequirment = new ArtifactVersion() {
            @Override
            public String getLabel() {
                return "mixinbooter";
            }

            @Override
            public String getVersionString() {
                return null;
            }

            @Override
            public boolean containsVersion(ArtifactVersion source) {
                return false;
            }

            @Override
            public String getRangeString() {
                return null;
            }

            @Override
            public int compareTo(ArtifactVersion o) {
                return 0;
            }
        };
        metadata.requiredMods.add(mixinBooterRequirment);
    }

    @Override
    public File getSource() {
        return AAIFPlugin.coreModLocation;
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        return true;
    }
}

