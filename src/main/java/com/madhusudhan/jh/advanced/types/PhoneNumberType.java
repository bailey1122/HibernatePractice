package com.madhusudhan.jh.advanced.types;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.jdbc.Size;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.*;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class PhoneNumberType implements BasicType {
    public int[] sqlTypes() {
        return new int[] {
                IntegerType.INSTANCE.sqlType(),
                IntegerType.INSTANCE.sqlType(),
                StringType.INSTANCE.sqlType()
        };
    }
    public Class returnedClass() {
        return PhoneNumberT.class;
    }

    public String[] getRegistrationKeys() {
        return new String[0];
    }

    public boolean isAssociationType() {
        return false;
    }

    public boolean isCollectionType() {
        return false;
    }

    public boolean isEntityType() {
        return false;
    }

    public boolean isAnyType() {
        return false;
    }

    public boolean isComponentType() {
        return false;
    }

    public int getColumnSpan(Mapping mapping) throws MappingException {
        return 0;
    }

    public int[] sqlTypes(Mapping mapping) throws MappingException {
        return new int[0];
    }

    public Size[] dictatedSizes(Mapping mapping) throws MappingException {
        return new Size[0];
    }

    public Size[] defaultSizes(Mapping mapping) throws MappingException {
        return new Size[0];
    }

    public Class getReturnedClass() {
        return null;
    }

    public boolean isSame(Object x, Object y) throws HibernateException {
        return false;
    }

    public boolean isEqual(Object x, Object y) throws HibernateException {
        return false;
    }

    public boolean isEqual(Object x, Object y, SessionFactoryImplementor factory) throws HibernateException {
        return false;
    }

    public int getHashCode(Object x) throws HibernateException {
        return 0;
    }

    public int getHashCode(Object x, SessionFactoryImplementor factory) throws HibernateException {
        return 0;
    }

    public int compare(Object x, Object y) {
        return 0;
    }

    public boolean isDirty(Object old, Object current, SharedSessionContractImplementor session) throws HibernateException {
        return false;
    }

    public boolean isDirty(Object oldState, Object currentState, boolean[] checkable, SharedSessionContractImplementor session) throws HibernateException {
        return false;
    }

    public boolean isModified(Object dbState, Object currentState, boolean[] checkable, SharedSessionContractImplementor session) throws HibernateException {
        return false;
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        return null;
    }

    public Object nullSafeGet(ResultSet rs, String name, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        return null;
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index, boolean[] settable, SharedSessionContractImplementor session) throws HibernateException, SQLException {

    }

    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {

    }

    public String toLoggableString(Object value, SessionFactoryImplementor factory) throws HibernateException {
        return null;
    }

    public String getName() {
        return null;
    }

    public Object deepCopy(Object value, SessionFactoryImplementor factory) throws HibernateException {
        return null;
    }

    public boolean isMutable() {
        return false;
    }

    public Serializable disassemble(Object value, SharedSessionContractImplementor session, Object owner) throws HibernateException {
        return null;
    }

    public Object assemble(Serializable cached, SharedSessionContractImplementor session, Object owner) throws HibernateException {
        return null;
    }

    public void beforeAssemble(Serializable cached, SharedSessionContractImplementor session) {

    }

    public Object hydrate(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        return null;
    }

    public Object resolve(Object value, SharedSessionContractImplementor session, Object owner) throws HibernateException {
        return null;
    }

    public Object semiResolve(Object value, SharedSessionContractImplementor session, Object owner) throws HibernateException {
        return null;
    }

    public Type getSemiResolvedType(SessionFactoryImplementor factory) {
        return null;
    }

    public Object replace(Object original, Object target, SharedSessionContractImplementor session, Object owner, Map copyCache) throws HibernateException {
        return null;
    }

    public Object replace(Object original, Object target, SharedSessionContractImplementor session, Object owner, Map copyCache, ForeignKeyDirection foreignKeyDirection) throws HibernateException {
        return null;
    }

    public boolean[] toColumnNullness(Object value, Mapping mapping) {
        return new boolean[0];
    }
}
