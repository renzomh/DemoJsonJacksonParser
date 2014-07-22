package com.mdp.demojacksonparser;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdp.entities.Consultoras;
import com.mdp.entities.InformacionesFinancieras;
import com.mdp.entities.ProductosObligatorios;
import com.mdp.service.RESTClient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private Button btDemoJacksonInformacionFinanciera;
	private Button btDemoJacksonInformacionConsultora;
	private Button btDemoJacksonProdutosObligatorios;
	private TextView tvDemoJacksonConsumirResultado;
	
	private String url = null;
	
	private int servicioSeleccionado = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btDemoJacksonInformacionFinanciera = (Button) findViewById(R.id.btDemoJacksonInformacionFinanciera);
		btDemoJacksonInformacionConsultora = (Button) findViewById(R.id.btDemoJacksonInformacionConsultora);
		btDemoJacksonProdutosObligatorios = (Button) findViewById(R.id.btDemoJacksonProdutosObligatorios);
		tvDemoJacksonConsumirResultado = (TextView) findViewById(R.id.tvDemoJacksonConsumirResultado);
		
		btDemoJacksonInformacionFinanciera.setOnClickListener(this);
		btDemoJacksonInformacionConsultora.setOnClickListener(this);
		btDemoJacksonProdutosObligatorios.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class RESTTask extends AsyncTask<String, Void, String> {
    	
    	@Override
    	protected void onPreExecute()
    	{
    	}

		@Override
		protected String doInBackground(String... urls)
		{
			String response = "";
			
			for (String url : urls)
			{
				try
				{
					response = RESTClient.connectAndReturnResponse(url);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			return response;
		}

		@Override
		protected void onPostExecute(String result)
		{	
			try
			{
	        	JSONObject object = new JSONObject(result);
	        	JSONObject objectSalida = object.getJSONObject("tramaSalida");
	        	JSONObject objectDetalle = objectSalida.getJSONObject("detalle");
	        	JSONObject objectParametros = objectDetalle.getJSONObject("parametros");
	        	
	        	if(servicioSeleccionado == 1)
	        	{
	        		tvDemoJacksonConsumirResultado.setText("INFORMACIONES FINANCIERAS:\n\n");
	        		setearInformacionFinanciera(objectParametros);
	        	}
	        	else if(servicioSeleccionado == 2)
	        	{
	        		tvDemoJacksonConsumirResultado.setText("CONSULTORAS:\n\n");
	        		setearInformacionConsultoras(objectParametros);
	        	}
	        	else
	        	{
	        		tvDemoJacksonConsumirResultado.setText("PRODUCTOS OBLIGATORIOS:\n\n");
	        		setearProductosObligatorios(objectParametros);
	        	}
			}
	        catch (JSONException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
			catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		}

		private void setearProductosObligatorios(JSONObject objectParametros) {
			// TODO Auto-generated method stub
			
			JSONArray arrayInformacion;
			try
			{
				arrayInformacion = objectParametros.getJSONArray("listaMiniayudaProductos");
			
	        	ObjectMapper mapper = new ObjectMapper();
	        	ProductosObligatorios arrayData;
				arrayData = mapper.readValue(arrayInformacion.toString(), ProductosObligatorios.class);
	        	
	        	for(int i=0; i<arrayData.size(); i++)
	        	{
	        		tvDemoJacksonConsumirResultado.append("CodRapProd: " + arrayData.get(i).getCodRapProd() + "\n");
	        		tvDemoJacksonConsumirResultado.append("CabOferta: " + arrayData.get(i).getCabOferta() + "\n");
	        		tvDemoJacksonConsumirResultado.append("DescOferta: " + arrayData.get(i).getDescOferta() + "\n");
	        		tvDemoJacksonConsumirResultado.append("\n");
	        	}
			}
			catch (JSONException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void setearInformacionConsultoras(JSONObject objectParametros) {
			// TODO Auto-generated method stub
			
			JSONArray arrayInformacion;
			try
			{
				arrayInformacion = objectParametros.getJSONArray("listaInfoPersonalConsultora");
			
	        	ObjectMapper mapper = new ObjectMapper();
	        	Consultoras arrayData;
				arrayData = mapper.readValue(arrayInformacion.toString(), Consultoras.class);
	        	
	        	for(int i=0; i<arrayData.size(); i++)
	        	{
	        		tvDemoJacksonConsumirResultado.append("CodConsultora: " + arrayData.get(i).getCodigoConsultora() + "\n");
	        		tvDemoJacksonConsumirResultado.append("Nombres: " + arrayData.get(i).getNombre() + "\n");
	        		tvDemoJacksonConsumirResultado.append("Apellidos: " + arrayData.get(i).getApellidoPaterno() + " " + arrayData.get(i).getApellidoMaterno() + "\n");
	        		tvDemoJacksonConsumirResultado.append("\n");
	        	}
			}
			catch (JSONException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void setearInformacionFinanciera(JSONObject objectParametros) {
			// TODO Auto-generated method stub
			
			JSONArray arrayInformacion;
			try
			{
				arrayInformacion = objectParametros.getJSONArray("listaInfoFinancieraConsultora");
			
	        	ObjectMapper mapper = new ObjectMapper();
	        	InformacionesFinancieras arrayData;
				arrayData = mapper.readValue(arrayInformacion.toString(), InformacionesFinancieras.class);
	        	
	        	for(int i=0; i<arrayData.size(); i++)
	        	{
	        		tvDemoJacksonConsumirResultado.append("CodConsultora: " + arrayData.get(i).getCodigoConsultora() + "\n");
	        		tvDemoJacksonConsumirResultado.append("CodPais: " + arrayData.get(i).getCodigoPais() + "\n");
	        		tvDemoJacksonConsumirResultado.append("Credito: " + arrayData.get(i).getCreditoDisponible() + "\n");
	        		tvDemoJacksonConsumirResultado.append("CSTTCRD: " + arrayData.get(i).getDescripcionCSTTCRD() + "\n");
	        		tvDemoJacksonConsumirResultado.append("DescStCred: " + arrayData.get(i).getDescStCred() + "\n");
	        		tvDemoJacksonConsumirResultado.append("\n");
	        	}
			}
			catch (JSONException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		String host_name = "http://proxynp.unique-yanbal.com/";
		String service_name = "";
		String id_pais = "1";
		String cod_usuario = "";
		String password = "password";
		String codigoaplicacion = "IOS_PEDIDOS";
		String codigointerfaz = "";
		String codigopais = "PER";
		String codigopaisod = "PER";
		String usuarioaplicacion = "10606";
		
		switch (v.getId())
		{
			case R.id.btDemoJacksonInformacionFinanciera:
				servicioSeleccionado = 1;
				service_name = "informacionfinancieraconsultora";
				codigointerfaz = "CINFFINCON";
				cod_usuario = "13634";
				
				break;

			case R.id.btDemoJacksonInformacionConsultora:
				servicioSeleccionado = 2;
				service_name = "informacionpersonalconsultora";
				codigointerfaz = "CINFPERCON";
				cod_usuario = "10606";
				
				break;
				
			case R.id.btDemoJacksonProdutosObligatorios:
				servicioSeleccionado = 3;
				service_name = "miniayudaproducto";
				codigointerfaz = "CMINAYUPROD";
				cod_usuario = "13634";
				
				break;	
			
			default:
				break;
		}
		
		url =  host_name + "extranetdesa/ExtranetPedidosRestWeb/servicio/pedido/" + service_name + "/" + id_pais + "/" + 
				cod_usuario + "/" + password + "?codigoaplicacion=" + codigoaplicacion + "&codigointerfaz=" + codigointerfaz + "&codigopais=" + codigopais + 
				"&codigopaisod=" + codigopaisod + "&usuarioaplicacion=" + usuarioaplicacion;
		
		try
		{
    		RESTTask task = new RESTTask();
    		task.execute(new String[] { url });
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
