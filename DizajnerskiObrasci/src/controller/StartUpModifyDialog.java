package controller;


import model.*;
import view.*;


public class StartUpModifyDialog {
	
	static public void startDialog(Shape shape, Model model, MainPanel mainPanel) {
		
		MyDialog dialog = null;

		
		if (shape instanceof Point) {
			dialog = new DlgPoint();
			Point point =(Point)shape;
			((DlgPoint)dialog).setTextX("" + point.getX());
			((DlgPoint)dialog).setTextY("" + point.getY());
		}
		else if (shape instanceof Line) {
			dialog = new DlgLine();
			Line line =(Line)shape;
			((DlgLine)dialog).setTextX1("" + line.getStartPoint().getX());
			((DlgLine)dialog).setTextY1("" + line.getStartPoint().getY());
			
			((DlgLine)dialog).setTextX2("" + line.getEndPoint().getX());
			((DlgLine)dialog).setTextY2("" + line.getEndPoint().getY());
		}
		else if (shape instanceof Donut) {
			
			dialog = new DlgDonut();
			
			Donut donut =(Donut)shape;
			((DlgDonut)dialog).setTextX("" + donut.getCenter().getX());
			((DlgDonut)dialog).setTextY("" + donut.getCenter().getY());
			((DlgDonut)dialog).setTextInnerR("" + donut.getInnerRadius());
			((DlgDonut)dialog).setTextOuterR("" + donut.getRadius());
		}
		else if (shape instanceof Circle) {
			dialog = new DlgCircle();
			Circle circle =(Circle)shape;
			((DlgCircle)dialog).setTextX("" + circle.getCenter().getX());
			((DlgCircle)dialog).setTextY("" + circle.getCenter().getY());
			((DlgCircle)dialog).setTextR("" + circle.getRadius());
		}
		else if (shape instanceof Rectangle) {
			dialog = new DlgRectangle();
			
			Rectangle rect =(Rectangle)shape;
			((DlgRectangle)dialog).setTextX("" + rect.getUpperLeft().getX());
			((DlgRectangle)dialog).setTextY("" + rect.getUpperLeft().getY());
			((DlgRectangle)dialog).setTextW("" + rect.getWidth());
			((DlgRectangle)dialog).setTextH("" + rect.getHeight());
		}
		
		else if (shape instanceof HexagonAdapter) {
			dialog = new DlgHexagon();
			HexagonAdapter hexagon =(HexagonAdapter)shape;
			((DlgHexagon)dialog).setTextX("" + hexagon.getCenter().getX());
			((DlgHexagon)dialog).setTextY("" + hexagon.getCenter().getY());
			((DlgHexagon)dialog).setTextR("" + hexagon.getR());
		}
		
		ColorButtonPanel panel = dialog.getColorButtonPanel();
		panel.setEdgeColor(shape.getEdgeColor());
		if(shape instanceof SurfaceShape) {
			panel.setInnerColor(((SurfaceShape)shape).getInnerColor());
			
		}
		else {
			panel.setVisibleInnerColorBtn(false);
		}
		
		dialog.conectDialogToShape(shape);
		dialog.setModel(model);
		dialog.connectDialogToMainPanel(mainPanel);
		dialog.setVisible(true);

		
		
		
	}

}
