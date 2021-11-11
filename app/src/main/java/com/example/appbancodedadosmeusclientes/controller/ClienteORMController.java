package com.example.appbancodedadosmeusclientes.controller;

import com.example.appbancodedadosmeusclientes.model.ClienteORM;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class ClienteORMController {

    public void insert(ClienteORM obj){

        Realm realm = Realm.getDefaultInstance();

        Number primaryKey = realm.where(ClienteORM.class).max("id");

        final int autoIncrementPrimaryKey = (primaryKey == null) ? 1 : primaryKey.intValue() +1;

        obj.setId(autoIncrementPrimaryKey);

        realm.beginTransaction();
        realm.copyToRealm(obj);
        realm.commitTransaction();
        realm.close();

    }

    public void update(ClienteORM obj){

        Realm realm = Realm.getDefaultInstance();

        ClienteORM clienteORM = realm.where(ClienteORM.class).equalTo("id", obj.getId())
                .findFirst();

        if (clienteORM != null) {

            realm.beginTransaction();

            clienteORM.setNome(obj.getNome());
            clienteORM.setSalario(obj.getSalario());
            clienteORM.setPreco(obj.getPreco());
            clienteORM.setDataCadastro(obj.getDataCadastro());
            clienteORM.setHoraCadastro(obj.getHoraCadastro());
            clienteORM.setAtivo(obj.isAtivo());

            realm.commitTransaction();
        }
        realm.close();

    }

    public void delete(ClienteORM obj){

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmResults<ClienteORM> results = realm.where(ClienteORM.class).equalTo("id",obj.getId())
                .findAll();

        results.deleteAllFromRealm();

        realm.commitTransaction();

        realm.close();

    }

    public void deleteById(int id){

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmResults<ClienteORM> results = realm.where(ClienteORM.class).equalTo("id",id)
                .findAll();

        results.deleteAllFromRealm();

        realm.commitTransaction();

        realm.close();

    }

    public List<ClienteORM> listar(){

        Realm realm = null;

        RealmResults<ClienteORM> results = null;

        List<ClienteORM> list = new ArrayList<>();

        try {
            realm = Realm.getDefaultInstance();

            results = realm.where(ClienteORM.class).findAll();
            list = realm.copyFromRealm(results);


        }catch (RealmException e){

        }finally {
            realm.close();
        }

        return list;
    }

    public ClienteORM getById(int id){

        Realm realm = Realm.getDefaultInstance();

        ClienteORM obj = null;

        try{

            obj = realm.copyFromRealm(Objects.requireNonNull(Objects.requireNonNull(realm.where(ClienteORM.class)).equalTo("id", id).findFirst()));


        }catch (Exception e){

        }

        return obj;
    }

}
