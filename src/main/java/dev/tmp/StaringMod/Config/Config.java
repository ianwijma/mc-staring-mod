package dev.tmp.StaringMod.Config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import dev.tmp.StaringMod.StaringMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.io.File;

@Mod.EventBusSubscriber
public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CONFIG;

    static {
        BlacklistWhitelistConfig.init( BUILDER );

        TimingConfig.init( BUILDER );

        CONFIG = BUILDER.build();
    }

    public static void loadConfig( ForgeConfigSpec config, String path ) {
        StaringMod.LOGGER.info( "Loading config: " + path );
        final File file = new File( path );
        final CommentedFileConfig configFile = CommentedFileConfig.builder( file )
                .sync()
                .autosave()
                .writingMode( WritingMode.REPLACE )
                .build();

        StaringMod.LOGGER.info( "Build config: " + path );
        configFile.load();

        StaringMod.LOGGER.info( "Loaded config: " + path );
        config.setConfig( configFile );

        StaringMod.LOGGER.info( "Config loaded: " + path );
    }



}