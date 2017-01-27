package com.adero.thing;

import com.thingworx.logging.LogUtilities;
import com.thingworx.metadata.annotations.ThingworxBaseTemplateDefinition;
import com.thingworx.metadata.annotations.ThingworxServiceDefinition;
import com.thingworx.metadata.annotations.ThingworxServiceParameter;
import com.thingworx.metadata.annotations.ThingworxServiceResult;
import com.thingworx.things.Thing;
import org.slf4j.Logger;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

@ThingworxBaseTemplateDefinition(name = "GenericThing")
public class ProcessVIFinal extends Thing {

	private static Logger _logger = LogUtilities.getInstance().getApplicationLogger(ProcessVIFinal.class);

	public ProcessVIFinal() {
		// TODO Auto-generated constructor stub
	}
	
	public static float NDVI(float r, float b)
	{
		float ndvi;
	    float num = r-b;
	    float denom = r+b;
        if (denom != 0.0F) {
            ndvi = num / denom;
        } else {
            ndvi = 0.0F;
        }

        if (ndvi < 0.0F) {
            ndvi = 0.0F;
        } else if (ndvi > 1.0F) {
            ndvi = 1.0F;
        }
		return ndvi;
	}
	public static float SR(float r, float b)
	{
		float sr;
		sr = r/b;
		return sr;
	}
	public static float MSR(float r, float b)
	{
		float msr;
		msr = (float) (((r/b)-1)/((Math.pow((r/b),(1/2)))+1));
		return msr;
	}
	public static float DVI(float r, float b)
	{
		float dvi;
		dvi = r-b;
		return dvi;
	}
	public static float GNDVI(float r, float g, float b)
	{
		float gndvi;
		gndvi = (r-g)/(r+g);
		return gndvi;
	}
	public static float RDVI(float r, float b)
	{
		float rdvi;
		rdvi = (float) ((r-b)/Math.sqrt((r+b)));
		return rdvi;
	}
	public static float IPVI(float r, float b)
	{
		float sr;
		sr = r/(r+b);
		return sr;
	}
	public static float SAVI(float r, float b)
	{
		float savi;
		float L=(float) 0.5;
		savi = ((1+L)*(r-b))/(r+b+L);
		return savi;
	}
	public static float OSAVI(float r, float b)
	{
		float sr;
		sr = (float) ((r-b)/(r+b+0.16));
		return sr;
	}
	public static float MSAVI(float r, float b)
	{
		float msavi;
		float t1 = ((2*r)+1)-(8*(r-b));
		float t2 = (float) ((2*r)+1-(Math.sqrt(t1)));
		msavi = 1/2*t2;
		return msavi;
	}
	public static float NLI(float r, float b)
	{
		float NLI;
		NLI = (float) ((Math.pow(r, 2)-b)/(Math.pow(r, 2)+b));
		return NLI;
	}
	public static float TVI(float r, float g, float b)
	{
		float tvi;
		tvi = (float) (0.5*((120*(r-g))-(200*(b-g))));
		return tvi;
	}
	public static float MTVI1(float r, float g, float b)
	{
		float mtvi1;
		mtvi1 = (float) (1.2*((1.2*(r-g))-(2.5*(b-g))));
		return mtvi1;
	}
	public static float MTVI2(float r, float g, float b)
	{
		float mtvi2;
		float t1 = (float) Math.sqrt(Math.pow((2*r+1), 2)-((6*r)-(5*Math.sqrt(b))-0.5));
		float t2 = (float) (1.2*((1.2*(r-g))-(2.5*(b-g))));
		mtvi2 = t1/t2;
		return mtvi2;
	}
	public static float NDGI(float r, float g, float b)
	{
		float ndgi;
		ndgi = (g-r)/(g+r);
		return ndgi;
	}
	public static float RVI(float r, float b)
	{
		float rvi;
		rvi = b/r;
		return rvi;
	}
	public static float VIN(float r, float b)
	{
		float VIN;
		VIN = r/b;
		return VIN;
	}

	public static int toRGB(int[] i) {
		int rgb = 0;
		rgb += (i[0] << 16);
		rgb += (i[1] << 8);
		rgb += i[2];
		return rgb;
	}
	
	public static int NDVIColor(float i) {
		int r = 0;
		int g = 0;
		int b = 0;
		if(i==0)
		{
			r=0;
			g=0;
			b=0;
	    }
		if(i>=0 && i<=1)
		{
			r=51;
			g=0;
			b=51;
		}
		else if(i>=1 && i<=2)
		{
			r=102;
			g=0;
			b=102;
		}
		else if(i>=2 && i<=3)
		{
			r=204;
			g=0;
			b=204;
		}
		else if(i>=3 && i<=4)
		{
			r=76;
			g=0;
			b=153;
		}
		else if(i>=4 && i<=5)
		{
			r=0;
			g=0;
			b=102;
		}
		else if(i>=6 && i<=10)
		{
			r=0;
			g=0;
			b=153;
		}
		else if(i>=11 && i<=15)
		{
			r=0;
			g=0;
			b=204;
		}
		else if(i>=16 && i<=20)
		{
			r=0;
			g=102;
			b=102;
		}
		else if(i>=21 && i<=25)
		{
			r=0;
			g=204;
			b=204;
		}
		else if(i>=26 && i<=30)
		{
			r=153;
			g=255;
			b=204;
		}
		else if(i>=31 && i<=35)
		{
			r=51;
			g=255;
			b=51;
		}
		else if(i>=36 && i<=40)
		{
			r=178;
			g=255;
			b=102;
		}
		else if(i>=41 && i<=45)
		{
			r=153;
			g=255;
			b=51;
		}
		else if(i>=46 && i<=50)
		{
			r=204;
			g=255;
			b=153;
		}
		else if(i>=51 && i<=55)
		{
			r=255;
			g=255;
			b=102;
		}
		else if(i>=56 && i<=60)
		{
			r=102;
			g=102;
			b=0;
		}
		else if(i>=61 && i<=65)
		{
			r=255;
			g=0;
			b=0;
		}
		else if(i>=66 && i<=255)
		{
			r=255;
			g=102;
			b=102;
		}
		

		return toRGB(new int[] { r, g, b });
	}
	

	@ThingworxServiceDefinition(name = "ProcessVIF", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "Result", description = "", baseType = "IMAGE", aspects = {})
	public byte[] ProcessVIF(
			@ThingworxServiceParameter(name = "image", description = "", baseType = "IMAGE") byte[] image,
			@ThingworxServiceParameter(name = "VI", description = "", baseType = "STRING", aspects = {
					"defaultValue:NDVI" }) String VI_Type,
			@ThingworxServiceParameter(name = "Type", description = "", baseType = "STRING", aspects = {
					"defaultValue:Color" }) String Type) {
		_logger.trace("Entering Service: ProcessVIF");
		
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(image);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
	          float vi = 0;
              //    ndvi = basec[0];

              switch(VI_Type)
              {
                  case "NDVI":
                  {
                      vi = NDVI(r,b);
                      break;
                  }
                  case "SR":
                  {
                      vi = SR(r,b);
                      break;
                  }
                  case "MSR":
                  {
                      vi = MSR(r,b);
                      break;
                  }
                  case "DVI":
                  {
                      vi = DVI(r,b);
                      break;
                  }
                  case "GNDVI":
                  {
                      vi = GNDVI(r,g,b);
                      break;
                  }
                  case "RDVI":
                  {
                      vi = RDVI(r,b);
                      break;
                  }
                  case "IPVI":
                  {
                      vi = IPVI(r,b);
                      break;
                  }
                  case "SAVI":
                  {
                      vi = SAVI(r,b);
                      break;
                  }
                  case "MSAVI":
                  {
                      vi = MSAVI(r,b);
                      break;
                  }
                  case "NLI":
                  {
                      vi = NLI(r,b);
                      break;
                  }
                  case "TVI":
                  {
                      vi = TVI(r,g,b);
                      break;
                  }
                  case "MTVI1":
                  {
                      vi = MTVI1(r,g,b);
                      break;
                  }
                  case "MTVI2":
                  {
                      vi = MTVI2(r,g,b);
                      break;
                  }
                  case "NDGI":
                  {
                      vi = NDGI(r,g,b);
                      break;
                  }
                  case "RVI":
                  {
                      vi = RVI(r,b);
                      break;
                  }
                  case "VIN":
                  {
                      vi = VIN(r,b);
                      break;
                  }
                  default:
                  {
                      vi = NDVI(r,b);
                  }

              }
		    
            
		    

		    
		    int vibyte = (int) (255*vi);
		    
		    switch(Type)
		    {
		    case "Color":
		    {
		        map.setRGB(x, y, NDVIColor(vibyte));
		        break;
		    }
		    case "Grey":
		    {
		    	map.setRGB(x, y, toRGB(new int[] { vibyte, vibyte, vibyte }));
		    	break;
		    }
		    default:
		    {
		    	map.setRGB(x, y, NDVIColor(vibyte));
		    }
		    }
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		_logger.trace("Exiting Service: ProcessVIF");
		return result;
	}

}
