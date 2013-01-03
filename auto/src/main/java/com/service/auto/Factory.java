package com.service.auto;

import com.service.auto.*;

public class Factory {

		private static AUTOImplDAO autoImplDAO = null;
		private static BONImplDAO bonImplDAO = null;
		private static MARCAImplDAO marcaImplDAO = null;
		private static MECANICImplDAO mecanicImplDAO = null;
		private static MODELImplDAO modelImplDAO = null;
		private static OPERATIEImplDAO operatieImplDAO = null;
		private static PIESEImplDAO pieseImplDAO = null;
		private static PROPRIETARImplDAO proprietarImplDAO = null;
		
				private static Factory instance = null;

		public static synchronized Factory getInstance() {
			if (instance == null) {
				instance = new Factory();
			}
			return instance;
		}

		public AUTOImplDAO getAutoDAO() {
			if (autoImplDAO == null) {
				autoImplDAO = new AUTOImplDAO();
			}
			return autoImplDAO;
		}
		
		
		public BONImplDAO getBonDAO() {
			if (bonImplDAO == null) {
				bonImplDAO = new BONImplDAO();
			}
			return bonImplDAO;
		}
		
		public MARCAImplDAO getMarcaDAO() {
			if (marcaImplDAO == null) {
				marcaImplDAO = new MARCAImplDAO();
			}
			return marcaImplDAO;
		}

		public MECANICImplDAO getMecanicDAO() {
			if (mecanicImplDAO == null) {
				mecanicImplDAO = new MECANICImplDAO();
			}
			return mecanicImplDAO;
		}
		
		public MODELImplDAO getModelDAO() {
			if (modelImplDAO == null) {
				modelImplDAO = new MODELImplDAO();
			}
			return modelImplDAO;
		}
		
		public OPERATIEImplDAO getOperatieDAO() {
			if (operatieImplDAO == null) {
				operatieImplDAO = new OPERATIEImplDAO();
			}
			return operatieImplDAO;
		}
		
		public PIESEImplDAO getPieseDAO() {
			if (pieseImplDAO == null) {
				pieseImplDAO = new PIESEImplDAO();
			}
			return pieseImplDAO;
		}
		
		public PROPRIETARImplDAO getProprietarDAO() {
			if (proprietarImplDAO == null) {
				proprietarImplDAO = new PROPRIETARImplDAO();
			}
			return proprietarImplDAO;
		}
	}

