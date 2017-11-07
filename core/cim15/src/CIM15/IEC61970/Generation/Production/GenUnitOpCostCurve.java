/**
 */
package CIM15.IEC61970.Generation.Production;

import CIM15.IEC61970.Core.Curve;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Unit Op Cost Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CIM15.IEC61970.Generation.Production.GenUnitOpCostCurve#isIsNetGrossP <em>Is Net Gross P</em>}</li>
 *   <li>{@link CIM15.IEC61970.Generation.Production.GenUnitOpCostCurve#getGeneratingUnit <em>Generating Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenUnitOpCostCurve extends Curve {
	/**
	 * The default value of the '{@link #isIsNetGrossP() <em>Is Net Gross P</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNetGrossP()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_NET_GROSS_P_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsNetGrossP() <em>Is Net Gross P</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNetGrossP()
	 * @generated
	 * @ordered
	 */
	protected boolean isNetGrossP = IS_NET_GROSS_P_EDEFAULT;

	/**
	 * This is true if the Is Net Gross P attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isNetGrossPESet;

	/**
	 * The cached value of the '{@link #getGeneratingUnit() <em>Generating Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratingUnit()
	 * @generated
	 * @ordered
	 */
	protected GeneratingUnit generatingUnit;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenUnitOpCostCurve() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProductionPackage.Literals.GEN_UNIT_OP_COST_CURVE;
	}

	/**
	 * Returns the value of the '<em><b>Is Net Gross P</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Net Gross P</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Net Gross P</em>' attribute.
	 * @see #isSetIsNetGrossP()
	 * @see #unsetIsNetGrossP()
	 * @see #setIsNetGrossP(boolean)
	 * @generated
	 */
	public boolean isIsNetGrossP() {
		return isNetGrossP;
	}

	/**
	 * Sets the value of the '{@link CIM15.IEC61970.Generation.Production.GenUnitOpCostCurve#isIsNetGrossP <em>Is Net Gross P</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Net Gross P</em>' attribute.
	 * @see #isSetIsNetGrossP()
	 * @see #unsetIsNetGrossP()
	 * @see #isIsNetGrossP()
	 * @generated
	 */
	public void setIsNetGrossP(boolean newIsNetGrossP) {
		isNetGrossP = newIsNetGrossP;
		isNetGrossPESet = true;
	}

	/**
	 * Unsets the value of the '{@link CIM15.IEC61970.Generation.Production.GenUnitOpCostCurve#isIsNetGrossP <em>Is Net Gross P</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsNetGrossP()
	 * @see #isIsNetGrossP()
	 * @see #setIsNetGrossP(boolean)
	 * @generated
	 */
	public void unsetIsNetGrossP() {
		isNetGrossP = IS_NET_GROSS_P_EDEFAULT;
		isNetGrossPESet = false;
	}

	/**
	 * Returns whether the value of the '{@link CIM15.IEC61970.Generation.Production.GenUnitOpCostCurve#isIsNetGrossP <em>Is Net Gross P</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Net Gross P</em>' attribute is set.
	 * @see #unsetIsNetGrossP()
	 * @see #isIsNetGrossP()
	 * @see #setIsNetGrossP(boolean)
	 * @generated
	 */
	public boolean isSetIsNetGrossP() {
		return isNetGrossPESet;
	}

	/**
	 * Returns the value of the '<em><b>Generating Unit</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link CIM15.IEC61970.Generation.Production.GeneratingUnit#getGenUnitOpCostCurves <em>Gen Unit Op Cost Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generating Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generating Unit</em>' reference.
	 * @see #setGeneratingUnit(GeneratingUnit)
	 * @see CIM15.IEC61970.Generation.Production.GeneratingUnit#getGenUnitOpCostCurves
	 * @generated
	 */
	public GeneratingUnit getGeneratingUnit() {
		if (generatingUnit != null && generatingUnit.eIsProxy()) {
			InternalEObject oldGeneratingUnit = (InternalEObject)generatingUnit;
			generatingUnit = (GeneratingUnit)eResolveProxy(oldGeneratingUnit);
			if (generatingUnit != oldGeneratingUnit) {
			}
		}
		return generatingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratingUnit basicGetGeneratingUnit() {
		return generatingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGeneratingUnit(GeneratingUnit newGeneratingUnit, NotificationChain msgs) {
		GeneratingUnit oldGeneratingUnit = generatingUnit;
		generatingUnit = newGeneratingUnit;
		return msgs;
	}

	/**
	 * Sets the value of the '{@link CIM15.IEC61970.Generation.Production.GenUnitOpCostCurve#getGeneratingUnit <em>Generating Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generating Unit</em>' reference.
	 * @see #getGeneratingUnit()
	 * @generated
	 */
	public void setGeneratingUnit(GeneratingUnit newGeneratingUnit) {
		if (newGeneratingUnit != generatingUnit) {
			NotificationChain msgs = null;
			if (generatingUnit != null)
				msgs = ((InternalEObject)generatingUnit).eInverseRemove(this, ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES, GeneratingUnit.class, msgs);
			if (newGeneratingUnit != null)
				msgs = ((InternalEObject)newGeneratingUnit).eInverseAdd(this, ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES, GeneratingUnit.class, msgs);
			msgs = basicSetGeneratingUnit(newGeneratingUnit, msgs);
			if (msgs != null) msgs.dispatch();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.GEN_UNIT_OP_COST_CURVE__GENERATING_UNIT:
				if (generatingUnit != null)
					msgs = ((InternalEObject)generatingUnit).eInverseRemove(this, ProductionPackage.GENERATING_UNIT__GEN_UNIT_OP_COST_CURVES, GeneratingUnit.class, msgs);
				return basicSetGeneratingUnit((GeneratingUnit)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProductionPackage.GEN_UNIT_OP_COST_CURVE__GENERATING_UNIT:
				return basicSetGeneratingUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProductionPackage.GEN_UNIT_OP_COST_CURVE__IS_NET_GROSS_P:
				return isIsNetGrossP();
			case ProductionPackage.GEN_UNIT_OP_COST_CURVE__GENERATING_UNIT:
				if (resolve) return getGeneratingUnit();
				return basicGetGeneratingUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProductionPackage.GEN_UNIT_OP_COST_CURVE__IS_NET_GROSS_P:
				setIsNetGrossP((Boolean)newValue);
				return;
			case ProductionPackage.GEN_UNIT_OP_COST_CURVE__GENERATING_UNIT:
				setGeneratingUnit((GeneratingUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ProductionPackage.GEN_UNIT_OP_COST_CURVE__IS_NET_GROSS_P:
				unsetIsNetGrossP();
				return;
			case ProductionPackage.GEN_UNIT_OP_COST_CURVE__GENERATING_UNIT:
				setGeneratingUnit((GeneratingUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ProductionPackage.GEN_UNIT_OP_COST_CURVE__IS_NET_GROSS_P:
				return isSetIsNetGrossP();
			case ProductionPackage.GEN_UNIT_OP_COST_CURVE__GENERATING_UNIT:
				return generatingUnit != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isNetGrossP: ");
		if (isNetGrossPESet) result.append(isNetGrossP); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} // GenUnitOpCostCurve
