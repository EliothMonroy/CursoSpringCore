package org.certificatic.spring.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String FECHA_FORMAT = "dd/MM/yyyy";
	public static String HORA_FORMAT = "HH:mm:ss";
	public static String FECHA_HORA_FORMAT = "dd/MM/yy HH:mm:ss";

	public static enum CampoFecha {
		MES(1), DIA(2), HORA(3), MINUTO(4), SEGUNDO(5);

		private final int idCampoFecha;

		CampoFecha(final int idCampoFecha) {
			this.idCampoFecha = idCampoFecha;
		}

		public int getIdCampoFecha() {
			return idCampoFecha;
		}

	}

	public static Date parseFecha(final String fecha) {
		final SimpleDateFormat sdf = new SimpleDateFormat(FECHA_FORMAT);
		sdf.setLenient(false);

		Date d = null;
		try {
			d = sdf.parse(fecha);
		} catch (final ParseException e) {
			throwException(e.getMessage());
		}
		return d;
	}

	public static String parseFechaFormateada(final Date fecha) {
		final SimpleDateFormat sdf = new SimpleDateFormat(FECHA_FORMAT);
		sdf.setLenient(false);

		return sdf.format(fecha);
	}

	public static Date parseFecha(final Date fecha) {
		final SimpleDateFormat sdf = new SimpleDateFormat(FECHA_FORMAT);
		sdf.setLenient(false);

		final String formatedFecha = sdf.format(fecha);

		Date d = null;
		try {
			d = sdf.parse(formatedFecha);
		} catch (final ParseException e) {
			throwException(e.getMessage());
		}
		return d;
	}

	public static Date parseFechaHora(final String fechaHora) {
		final SimpleDateFormat sdf = new SimpleDateFormat(FECHA_HORA_FORMAT);
		sdf.setLenient(false);

		Date d = null;
		try {
			d = sdf.parse(fechaHora);
		} catch (final ParseException e) {
			throwException(e.getMessage());
		}
		return d;
	}

	public static Date parseFechaHora(final Date fechaHora) {
		final SimpleDateFormat sdf = new SimpleDateFormat(FECHA_HORA_FORMAT);
		sdf.setLenient(false);

		final String formatedFecha = sdf.format(fechaHora);

		Date d = null;
		try {
			d = sdf.parse(formatedFecha);
		} catch (final ParseException e) {
			throwException(e.getMessage());
		}
		return d;
	}

	public static Date parseHora(final String hora) {
		final SimpleDateFormat sdf = new SimpleDateFormat(HORA_FORMAT);
		sdf.setLenient(false);

		Date d = null;
		try {
			d = sdf.parse(hora);
		} catch (final ParseException e) {
			throwException(e.getMessage());
		}
		return d;
	}

	public static Date parseHora(final Date hora) {
		final SimpleDateFormat sdf = new SimpleDateFormat(HORA_FORMAT);
		sdf.setLenient(false);

		final String formatedHora = sdf.format(hora);

		Date d = null;
		try {
			d = sdf.parse(formatedHora);
		} catch (final ParseException e) {
			throwException(e.getMessage());
		}
		return d;
	}

	public static Date sumarRestarDias(final Date fecha, final int dias) {
		final Calendar calendar = Calendar.getInstance();

		calendar.setTime(fecha);

		// resta dias si los dias < 0
		calendar.add(Calendar.DAY_OF_YEAR, dias);

		return calendar.getTime();
	}

	public static Long diferencia(final Date fecha1, final Date fecha2) {
		final Calendar calendar1 = Calendar.getInstance();
		final Calendar calendar2 = Calendar.getInstance();

		calendar1.setTime(fecha1);
		calendar2.setTime(fecha2);

		return calendar1.getTimeInMillis() - calendar2.getTimeInMillis();
	}

	public static Boolean esMayorIgual(final Date fecha1, final Date fecha2, final DateUtils.CampoFecha campoFecha) {
		return DateUtils.esIgual(fecha1, fecha2, campoFecha) || DateUtils.esMayor(fecha1, fecha2);
	}

	public static Boolean esMayor(final Date fecha1, final Date fecha2) {
		return DateUtils.diferencia(fecha1, fecha2) > 0 ? true : false;
	}

	public static Boolean esExactamenteIgual(final Date fecha1, final Date fecha2) {
		return DateUtils.diferencia(fecha1, fecha2) == 0 ? true : false;
	}

	public static Boolean esIgual(final Date fecha1, final Date fecha2, final CampoFecha campoFecha) {

		final Calendar calendarFecha1 = Calendar.getInstance();
		calendarFecha1.setTime(fecha1);

		final Calendar calendarFecha2 = Calendar.getInstance();
		calendarFecha2.setTime(fecha2);

		switch (campoFecha) {
		case MES:
			calendarFecha1.set(Calendar.DAY_OF_MONTH, 0);
			calendarFecha2.set(Calendar.DAY_OF_MONTH, 0);
		case DIA:
			calendarFecha1.set(Calendar.HOUR, 0);
			calendarFecha2.set(Calendar.HOUR, 0);
		case HORA:
			calendarFecha1.set(Calendar.MINUTE, 0);
			calendarFecha2.set(Calendar.MINUTE, 0);
		case MINUTO:
			calendarFecha1.set(Calendar.SECOND, 0);
			calendarFecha2.set(Calendar.SECOND, 0);
		case SEGUNDO:
			calendarFecha1.set(Calendar.MILLISECOND, 0);
			calendarFecha2.set(Calendar.MILLISECOND, 0);
			break;

		}
		final Date fechaTrunca1 = calendarFecha1.getTime();
		final Date fechaTrunca2 = calendarFecha2.getTime();

		return DateUtils.diferencia(fechaTrunca1, fechaTrunca2) == 0 ? true : false;
	}

	public static Date truncarFecha(final Date fecha, final CampoFecha campoFecha) {
		final Calendar calendarFecha = Calendar.getInstance();
		calendarFecha.setTime(fecha);

		switch (campoFecha) {
		case MES:
			calendarFecha.set(Calendar.DAY_OF_MONTH, 0);
		case DIA:
			calendarFecha.set(Calendar.HOUR, 0);
		case HORA:
			calendarFecha.set(Calendar.MINUTE, 0);
		case MINUTO:
			calendarFecha.set(Calendar.SECOND, 0);
		case SEGUNDO:
			calendarFecha.set(Calendar.MILLISECOND, 0);
			break;
		}

		return calendarFecha.getTime();
	}

	public static Boolean esMenor(final Date fecha1, final Date fecha2) {
		return DateUtils.diferencia(fecha1, fecha2) < 0 ? true : false;
	}

	public static Date obtenerFinDelDia(Date date) {

		final Calendar calendarFecha = Calendar.getInstance();

		calendarFecha.setTime(date);
		calendarFecha.set(Calendar.HOUR_OF_DAY, 23);
		calendarFecha.set(Calendar.MINUTE, 59);
		calendarFecha.set(Calendar.SECOND, 59);
		calendarFecha.set(Calendar.MILLISECOND, 59);

		return calendarFecha.getTime();
	}

	private static void throwException(final String mensaje) {
		throw new RuntimeException(mensaje);
	}

	public static Date inicializaFecha(Date fecha) {
		final Date fechaActual;
		final Calendar calendarFecha = Calendar.getInstance();
		if (fecha == null) {
			fechaActual = new Date();
			calendarFecha.setTime(fechaActual);
		} else {
			calendarFecha.setTime(fecha);
		}
		calendarFecha.set(Calendar.HOUR_OF_DAY, 0);
		calendarFecha.set(Calendar.MINUTE, 0);
		calendarFecha.set(Calendar.SECOND, 0);
		calendarFecha.set(Calendar.MILLISECOND, 0);
		final Date fechaTrunca = calendarFecha.getTime();
		return fechaTrunca;
	}

}
