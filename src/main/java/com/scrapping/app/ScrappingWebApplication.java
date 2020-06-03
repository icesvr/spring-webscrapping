package com.scrapping.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scrapping.app.models.Aviso;

@SpringBootApplication
public class ScrappingWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrappingWebApplication.class, args);
		
		try {
			Document doc = Jsoup.connect("http://yapo.cl").get();
			Elements menu = doc.getElementsByClass("region-links").select("a[href]");
			//Elements m = doc.getElementsByClass("region-links").select("a");
			
			Map<String, String> mapUrl = new HashMap<>();
			for(Element el : menu) {
				//System.out.println(el.attr("abs:href"));
				//System.out.println(el);
				mapUrl.put(el.text(), el.attr("abs:href"));	
				//urls.add(el.attr("abs:href"));
			}
			
			
			//System.out.println(menu.get(0));
			obtenerRuta(mapUrl);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String obtenerRuta(Map<String,String> urls) {
		
		
		Map<String,List<Aviso>> map = new HashMap<>();
		
		if(urls.size() > 0) {
						
			for(int i=0; i<urls.size();i++) {
				List<Aviso> avisosComuna = new ArrayList<Aviso>();
				try {
					Document document = Jsoup.connect(urls.get(i)).get();
					Elements aviso = document.getElementsByClass("ad listing_thumbs");
					if(!aviso.isEmpty()) {
						
						for(int x=0; x<aviso.size(); x++) {
							
							Aviso adv = new Aviso();
							adv.setTitulo(aviso.get(x).getElementsByClass("title").text());
							adv.setCategoria(aviso.get(x).getElementsByClass("clean_links").select("span").get(0).text());
							adv.setImg(aviso.get(x).getElementsByClass("listing_thumbs_image").select("img").attr("src"));
							adv.setPrecio(aviso.get(x).getElementsByClass("price").text());
							adv.setUrl(aviso.get(x).getElementsByClass("clean_links").select("a[href]").attr("abs:href"));
							adv.setRegion(aviso.get(x).getElementsByClass("clean_links").select("span").get(1).text());
							adv.setComuna(aviso.get(x).getElementsByClass("clean_links").select("span").get(2).text());
							avisosComuna.add(adv);
							map.put(urls.get(i), avisosComuna);								
						}						
					}		
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}	
		}

		
		
		return "";
	}

}
