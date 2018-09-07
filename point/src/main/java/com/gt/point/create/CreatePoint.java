package com.gt.point.create;

import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.*;

public class CreatePoint {

    private static final GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();

    public static Point createPoint(Double x, Double y) {
        Coordinate coord = new Coordinate(x, y);
        Point point = geometryFactory.createPoint(coord);

//        point.apply(filter);
        return point;
    }
}
