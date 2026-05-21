package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.ui.theme

import org.intellij.lang.annotations.Language

@Language("AGSL")
val BACKGROUND_SHADER_SRC = """
   uniform float2 iResolution;
   uniform float iTime;
   uniform float iDuration;
   
   // pseudo-random hash func
   float rand(vec2 co){
       return fract(sin(dot(co, vec2(12.9898, 78.233))) * 43758.5453);
   }
   
       half4 main(in vec2 fragCoord) {
          //test shader 
          //float2 scaled = abs(1.0-mod(fragCoord/iResolution.xy+iTime/(iDuration/2.0),2.0));
          
          // coords
          vec2 uv = (fragCoord * 2.0 - iResolution.xy) / iResolution.xy;
          // uv.y *= iResolution.y/iResolution.x;
          
          // divide into seperate squares 
          uv *= 3.0; // change if want more fracts
          uv = fract(uv);
          
          // generate random hash to assign random square
          float hash = rand(cellID); 
          

          
          
          
          half3 color = half3(uv,0.0);
          
      // return half4(scaled, 0, 1.0);
      return half4(color,1.0);
    }
""".trimIndent()