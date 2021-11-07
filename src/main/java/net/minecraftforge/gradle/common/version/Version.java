package net.minecraftforge.gradle.common.version;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.minecraftforge.gradle.common.Constants;

public class Version
{
    public String id;
    public Date time;
    public Date releaseTime;
    public String type;
    public String minecraftArguments;
    private List<Library> libraries;
    public String mainClass;
    public int minimumLauncherVersion;
    public String incompatibilityReason;
    private String assets;
    public List<OSRule> rules;
    
    private List<Library> _libraries;

    public List<Library> getLibraries()
    {
        if (_libraries == null)
        {
            _libraries = new ArrayList<Library>();
            if (libraries == null) return _libraries;
            for (Library lib : libraries)
            {
                if (lib.applies())
                {
                    if (lib.name.equals("net.sourceforge.argo:argo:2.25")) {
                        System.out.println("Bumping Agro version");
                        lib.name = "net.sourceforge.argo:argo:3.4";
                    }

                    if (lib.name.equals("org.ow2.asm:asm-debug-all:4.1")) {
                        System.out.println("Bumping ASM version");
                        lib.name = "org.ow2.asm:asm-all:5.0";
                    }

                    _libraries.add(lib);
                }
            }
        }
        return _libraries;
    }
    
    public String getAssets()
    {
        return assets == null ? Constants.ASSETS_INDEX : assets;
    }
}
