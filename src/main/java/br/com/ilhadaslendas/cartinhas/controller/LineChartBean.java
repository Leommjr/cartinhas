package br.com.ilhadaslendas.cartinhas.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;
import br.com.ilhadaslendas.cartinhas.model.CBLOLTeam;
import br.com.ilhadaslendas.cartinhas.services.CBLOLTeamsService;
import br.com.ilhadaslendas.cartinhas.utils.EnumTeams;
import br.com.ilhadaslendas.cartinhas.utils.EnumDates;

@Named
@RequestScoped
public class LineChartBean {

	private LineChartModel lineModel;
	
	@Inject
	private CBLOLTeamsService service;
	
	private List<List<CBLOLTeam>> teams;

	
	private String dynamicColor() {
		Random r = new Random();
		return "rgb( "+r.nextInt(255)+" , " + r.nextInt(255) + " , " + r.nextInt(255) + " )"; 
	}

	@PostConstruct
	public void init() {
		lineModel = new LineChartModel();
		ChartData data = new ChartData();
		allTeams();
		List<String> labels = new ArrayList<>();
		for(EnumDates date : EnumDates.values()) {
			LocalDate ld = date.getLocalDate();
			labels.add(ld.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			
		}
		data.setLabels(labels);
		for(List<CBLOLTeam> team : teams) {
			LineChartDataSet dataSet = new LineChartDataSet();
			List<Object> values = new ArrayList<>();
			for(CBLOLTeam t : team) {
				values.add(t.getRating());		
			}
			dataSet.setData(values);
			dataSet.setFill(false);
			dataSet.setLabel(team.get(0).getTeamName());
			dataSet.setBorderColor(dynamicColor());
			dataSet.setTension(0.1);
			data.addChartDataSet(dataSet);
		}
		

		// Options
		LineChartOptions options = new LineChartOptions();
		Title title = new Title();
		title.setDisplay(true);
		title.setText("Rating Times");
		options.setTitle(title);

		lineModel.setOptions(options);
		lineModel.setData(data);
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}
	
	public void allTeams() {
		List<List<CBLOLTeam>> localteams = new ArrayList<List<CBLOLTeam>>();
		for (EnumTeams time : EnumTeams.values()) {
			List<CBLOLTeam> ltime = service.find_name(time.name());
			if(!ltime.isEmpty()) {
				localteams.add(ltime);
			}
		}
		System.out.println(localteams);
		teams = localteams;
		
	}
	
}
