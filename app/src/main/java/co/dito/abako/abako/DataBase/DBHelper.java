package co.dito.abako.abako.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import co.dito.abako.abako.Entities.Agencia;
import co.dito.abako.abako.Entities.Almacenes;
import co.dito.abako.abako.Entities.AtributosEspeciales;
import co.dito.abako.abako.Entities.AtributosEspecialesSync;
import co.dito.abako.abako.Entities.CanalSync;
import co.dito.abako.abako.Entities.CarteraSync;
import co.dito.abako.abako.Entities.ClienteSync;
import co.dito.abako.abako.Entities.Configuraciones;
import co.dito.abako.abako.Entities.ContactoSync;
import co.dito.abako.abako.Entities.Empleado;
import co.dito.abako.abako.Entities.EstadoCartera;
import co.dito.abako.abako.Entities.FormaPago;
import co.dito.abako.abako.Entities.Frecuencia;
import co.dito.abako.abako.Entities.Inicia;
import co.dito.abako.abako.Entities.ListAgencia;
import co.dito.abako.abako.Entities.ListIp;
import co.dito.abako.abako.Entities.LoginResponce;
import co.dito.abako.abako.Entities.ResponseEmpleado;
import co.dito.abako.abako.Entities.RuteroSync;
import co.dito.abako.abako.Entities.ZonaSync;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlIntro = "CREATE TABLE intro (id integer primary key AUTOINCREMENT, idintro text )";

        String sqlNegocio = "CREATE TABLE negocio (CodigoNegocio text, Negocio text, UrlImg text )";

        String sqlAgencias = "CREATE TABLE agencia (key text, value text, idnegocio int)";

        String sqlIps = "CREATE TABLE ip (key text, value text, idnegocio int)";

        String sqlAgenciaEmple = "CREATE TABLE agencia_emple (Id TEXT)";

        String sqlAlmacenEmple = "CREATE TABLE almacen_emple (descripcion TEXT, id int, prd int)";

        String sqlConfiguracionesEmple = "CREATE TABLE configuracion_emple (valor TEXT, variable text)";

        String sqlEmpleaso = "CREATE TABLE empleado_negocio (nombre_empleado TEXT, id_empleado int, password TEXT)";





        String sqlClientes = "CREATE TABLE ClienteSync (id integer primary key AUTOINCREMENT, IdEmpresa INT, Razon_Social TEXT, Nombre_Comun TEXT, Identificacion  TEXT, Codigo TEXT, " +
                             "                          IdCanal INT, IdZona INT, IdLista_Precio INT, Longitud REAL, Latitud REAL, IdFormaPago INT, Cupo INT, Cantidad_Dias REAL, " +
                             "                          Frecuencia INT, Inicia INT, UltVt TEXT, Prcs TEXT, ultmpg Real, Fchltmpg TEXT)";

        String sqlCanales = "CREATE TABLE CanalSync (id integer primary key AUTOINCREMENT, IdCanal INT, Descripcion TEXT)";

        String sqlZona = "CREATE TABLE ZonaSync (id integer primary key AUTOINCREMENT, IdZona INT, Descripcion TEXT)";

        String sqlEspecialesSync = "CREATE TABLE AtributosEspecialesSync (id integer primary key AUTOINCREMENT, IdEmp INT, IdTipo INT, Valor TEXT)";

        String sqlFormaPago = "CREATE TABLE FormasPago (id integer primary key AUTOINCREMENT, Code TEXT, Description TEXT)";

        String sqlFrecuencia = "CREATE TABLE Frecuenciatb (id integer primary key AUTOINCREMENT, Code TEXT, Description TEXT)";

        String sqlInicia = "CREATE TABLE Inicia (id integer primary key AUTOINCREMENT, Code INT, Description TEXT)";

        String sqlAtributosEspeciales = "CREATE TABLE AtributosEspeciales (id integer primary key AUTOINCREMENT, Code INT, Description TEXT)";

        String sqlCartera = "CREATE TABLE cartera (id integer primary key AUTOINCREMENT, fac INT, venc TEXT, fecha_fac TEXT, dias_ven INT, decimal_p REAL, cuota INT, pgs_abns REAL, " +
                "           notas REAL, deducc REAL, concep REAL, mora REAL, periodo TEXT, std TEXT, id_emp INT, nota_noApli REAL, sald_fv REAL, prcs TEXT)";

        String sqlEstadoCartera = "CREATE TABLE estado_cartera (id integer primary key AUTOINCREMENT, code INT, description TEXT)";

        String sqlContacto = "CREATE TABLE contacto (id integer primary key AUTOINCREMENT, id_cnto INT, id_emp INT, nmbr TEXT, dir TEXT, id_cdd INT, tel TEXT, mail TEXT, pdt INT, " +
                "            tipo TEXT, prcs TEXT)";

        String sqlRutero = "CREATE TABLE rutero (id integer primary key AUTOINCREMENT, Id_rutero INT, Proceso TEXT, IdEmpresa INT, Dia INT, Orden REAL)";

        db.execSQL(sqlIntro);
        db.execSQL(sqlNegocio);
        db.execSQL(sqlAgencias);
        db.execSQL(sqlIps);
        db.execSQL(sqlAgenciaEmple);
        db.execSQL(sqlAlmacenEmple);
        db.execSQL(sqlConfiguracionesEmple);
        db.execSQL(sqlEmpleaso);
        db.execSQL(sqlClientes);
        db.execSQL(sqlCanales);
        db.execSQL(sqlZona);
        db.execSQL(sqlEspecialesSync);
        db.execSQL(sqlFormaPago);
        db.execSQL(sqlFrecuencia);
        db.execSQL(sqlInicia);
        db.execSQL(sqlAtributosEspeciales);
        db.execSQL(sqlCartera);
        db.execSQL(sqlEstadoCartera);
        db.execSQL(sqlContacto);
        db.execSQL(sqlRutero);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS intro");
        db.execSQL("DROP TABLE IF EXISTS negocio");
        db.execSQL("DROP TABLE IF EXISTS agencia");
        db.execSQL("DROP TABLE IF EXISTS ip");
        db.execSQL("DROP TABLE IF EXISTS agencia_emple");
        db.execSQL("DROP TABLE IF EXISTS almacen_emple");
        db.execSQL("DROP TABLE IF EXISTS configuracion_emple");
        db.execSQL("DROP TABLE IF EXISTS empleado_negocio");
        db.execSQL("DROP TABLE IF EXISTS ClienteSync");
        db.execSQL("DROP TABLE IF EXISTS CanalSync");
        db.execSQL("DROP TABLE IF EXISTS ZonaSync");
        db.execSQL("DROP TABLE IF EXISTS AtributosEspecialesSync");
        db.execSQL("DROP TABLE IF EXISTS FormasPago");
        db.execSQL("DROP TABLE IF EXISTS Frecuenciatb");
        db.execSQL("DROP TABLE IF EXISTS Inicia");
        db.execSQL("DROP TABLE IF EXISTS AtributosEspeciales");
        db.execSQL("DROP TABLE IF EXISTS cartera");
        db.execSQL("DROP TABLE IF EXISTS estado_cartera");
        db.execSQL("DROP TABLE IF EXISTS contacto");
        db.execSQL("DROP TABLE IF EXISTS rutero");

        this.onCreate(db);
    }

    public List<ClienteSync> selectClientesSyncs(){

        List<ClienteSync> clienteSyncList = new ArrayList<>();

        String sql_validate = "SELECT cli.id, cli.IdEmpresa, cli.Razon_Social, cli.Nombre_Comun, cli.Identificacion, cli.Codigo, cli.IdCanal, cli.IdZona, cli.IdLista_Precio, cli.Longitud, cli.Latitud, cli.IdFormaPago, " +
                " cli.Cupo, cli.Cantidad_Dias, cli.Frecuencia, cli.Inicia, cli.UltVt, cli.Prcs, cli.ultmpg, cli.Fchltmpg, con.dir, SUM(car.decimal_p) totalCsaartera " +
                " FROM ClienteSync AS cli , cartera AS car, contacto AS con WHERE cli.IdEmpresa = car.id_emp AND cli.IdEmpresa = con.id_emp GROUP BY cli.id ";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql_validate, null);

        ClienteSync clienteSync;

        if (cursor.moveToFirst()) {
            do {
                clienteSync = new ClienteSync();
                clienteSync.setId_empresa(cursor.getInt(1));
                clienteSync.setRazon_social(cursor.getString(2));
                clienteSync.setNombre_comun(cursor.getString(3));
                clienteSync.setIdentificacion(cursor.getString(4));
                clienteSync.setCodigo(cursor.getString(5));

                clienteSync.setUltmpg(cursor.getDouble(18));
                clienteSync.setFchltmpg(cursor.getString(19));

                clienteSync.setDireccion(cursor.getString(20));

                clienteSync.setSuma_factura(cursor.getDouble(21));



                clienteSyncList.add(clienteSync);
            } while(cursor.moveToNext());
        }

        return clienteSyncList;
    }

    public boolean insertClienteSync(List<ClienteSync> clienteSyncs){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        try {
            for (int i = 0; i < clienteSyncs.size(); i++){
                values.put("IdEmpresa", clienteSyncs.get(i).getId_empresa());
                values.put("Razon_Social", clienteSyncs.get(i).getRazon_social());
                values.put("Nombre_Comun", clienteSyncs.get(i).getNombre_comun());
                values.put("Identificacion", clienteSyncs.get(i).getIdentificacion());
                values.put("Codigo", clienteSyncs.get(i).getCodigo());
                values.put("IdCanal", clienteSyncs.get(i).getId_canal());
                values.put("IdZona", clienteSyncs.get(i).getId_zona());
                values.put("IdLista_Precio", clienteSyncs.get(i).getId_lista_precio());
                values.put("Longitud", clienteSyncs.get(i).getLongitud());
                values.put("Latitud", clienteSyncs.get(i).getLatitud());
                values.put("IdFormaPago", clienteSyncs.get(i).getId_forma_pago());
                values.put("Cupo", clienteSyncs.get(i).getCupo());
                values.put("Cantidad_Dias", clienteSyncs.get(i).getCantidad_dias());
                values.put("Frecuencia", clienteSyncs.get(i).getFrecuencia());
                values.put("Inicia", clienteSyncs.get(i).getInicia());
                values.put("UltVt", clienteSyncs.get(i).getUlt_vt());
                values.put("Prcs", clienteSyncs.get(i).getPrcs());
                values.put("ultmpg", clienteSyncs.get(i).getUltmpg());
                values.put("Fchltmpg", clienteSyncs.get(i).getFchltmpg());

                db.insert("ClienteSync", null, values);
            }
        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }
        db.close();
        return true;
    }

    public boolean validaDataTable(String table){
        Cursor cursor;
        boolean indicador = false;
        String sql = "SELECT * FROM "+table+" LIMIT 1";
        SQLiteDatabase db = this.getWritableDatabase();
        cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            indicador = true;
        }
        return indicador;
    }

    public boolean insertCanalSync (List<CanalSync> canalSyncs){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        try {
            for (int i = 0; i < canalSyncs.size(); i++){
                values.put("IdCanal", canalSyncs.get(i).getId_canal());
                values.put("Descripcion", canalSyncs.get(i).getDescripcion());

                db.insert("CanalSync", null, values);
            }

        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }

        db.close();
        return true;
    }

    public boolean inserTRutero (List<RuteroSync> Rutero){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        try {
            for (int i = 0; i < Rutero.size(); i++){
                values.put("Id_rutero", Rutero.get(i).getId());
                values.put("Proceso", Rutero.get(i).getProceso());
                values.put("IdEmpresa", Rutero.get(i).getIdEmpresa());
                values.put("Dia", Rutero.get(i).getDia());
                values.put("Orden", Rutero.get(i).getOrden());

                db.insert("rutero", null, values);

            }

        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }

        db.close();
        return true;
    }

    public boolean insertZonaSync (List<ZonaSync> zonaSyncs){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        try {
            for (int i = 0; i < zonaSyncs.size(); i++){
                values.put("IdZona", zonaSyncs.get(i).getId_zona());
                values.put("Descripcion", zonaSyncs.get(i).getDescripcion());

                db.insert("ZonaSync", null, values);
            }

        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }

        db.close();
        return true;
    }

    public boolean insertAtributosEspecialesSync (List<AtributosEspecialesSync> atributosEspecialesSyncs){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        try {
            for (int i = 0; i < atributosEspecialesSyncs.size(); i++){
                values.put("IdEmp", atributosEspecialesSyncs.get(i).getId_emp());
                values.put("IdTipo", atributosEspecialesSyncs.get(i).getId_tipo());
                values.put("Valor", atributosEspecialesSyncs.get(i).getValor());

                db.insert("AtributosEspecialesSync", null, values);
            }

        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }

        db.close();
        return true;
    }

    public boolean insertFormasPago (List<FormaPago> formaPagos){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        try {
            for (int i = 0; i < formaPagos.size(); i++){
                values.put("Code", formaPagos.get(i).getCode());
                values.put("Descripcion", formaPagos.get(i).getDescription());

                db.insert("FormasPago", null, values);
            }
        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }

        db.close();
        return true;
    }

    public boolean insertFrecuencia (List<Frecuencia> frecuencias){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        try {
            for (int i = 0; i < frecuencias.size(); i++){

                values.put("Code", frecuencias.get(i).getCode());
                values.put("Description", frecuencias.get(i).getDescription());

                db.insert("Frecuenciatb", null, values);
            }
        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }

        db.close();
        return true;
    }

    public boolean insertInicia (List<Inicia> inicias){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        try {
            for (int i = 0; i < inicias.size(); i++){
                values.put("Code", inicias.get(i).getCode());
                values.put("Descripcion", inicias.get(i).getDescription());

                db.insert("Inicia", null, values);
            }
        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }

        db.close();
        return true;
    }

    public boolean insertAtributosEspeciales (List<AtributosEspeciales> atributosEspeciales){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        try {
            for (int i = 0; i < atributosEspeciales.size(); i++){
                values.put("Code", atributosEspeciales.get(i).getCode());
                values.put("Descripcion", atributosEspeciales.get(i).getDescription());

                db.insert("AtributosEspeciales", null, values);
            }
        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }

        db.close();
        return true;

    }

    //region Insertar empleado.
    public boolean insertEmpleado(ResponseEmpleado data, String password){

        DeleteEmpleado();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        try {

            values.put("nombre_empleado", data.getNombre());
            values.put("id_empleado", data.getIdPersona());
            values.put("password", password);

            db.insert("empleado_negocio", null, values);

        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }

        db.close();
        return true;
    }
    //endregion

    public List<CarteraSync> selectCarteraIdEmpresa(int id_empresa){
        List<CarteraSync> carteraSyncList = new ArrayList<>();

        String sql = "SELECT id, fac, venc, fecha_fac, dias_ven, SUM(decimal_p), cuota, pgs_abns, notas, deducc, concep, mora, periodo, " +
                           " std, id_emp, nota_noApli, sald_fv, prcs FROM cartera WHERE id_emp ="+id_empresa+ " GROUP BY id";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        CarteraSync carteraSync;
        if (cursor.moveToFirst()) {
            do {
                carteraSync =  new CarteraSync();
                carteraSync.setFac(cursor.getInt(1));
                carteraSync.setVenc(cursor.getString(2));
                carteraSync.setFecha_fac(cursor.getString(3));

                carteraSync.setSld(cursor.getDouble(5));

                carteraSyncList.add(carteraSync);
            } while(cursor.moveToNext());
        }
        return carteraSyncList;
    }

    public double selectCarteraIdEmpresaSum(int id_empresa){

        double sumaTotal = 0.0;

        String sql = "SELECT SUM(decimal_p) AS suma FROM cartera WHERE id_emp = "+id_empresa + " GROUP BY id";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                sumaTotal = cursor.getDouble(0);
            } while(cursor.moveToNext());
        }

        return sumaTotal;
    }

    public boolean insertCartera(List<CarteraSync> cartera) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        try {
            for (int i = 0; i < cartera.size(); i++){
                values.put("fac", cartera.get(i).getFac());
                values.put("venc", cartera.get(i).getVenc());
                values.put("fecha_fac", cartera.get(i).getFecha_fac());
                values.put("dias_ven", cartera.get(i).getDias_ven());
                values.put("decimal_p", cartera.get(i).getSld());
                values.put("cuota", cartera.get(i).getCuota());
                values.put("pgs_abns", cartera.get(i).getPgs_abns());
                values.put("notas", cartera.get(i).getNotas());
                values.put("deducc", cartera.get(i).getDeducc());
                values.put("concep", cartera.get(i).getConcep());
                values.put("mora", cartera.get(i).getMora());
                values.put("periodo", cartera.get(i).getPeriodo());
                values.put("std", cartera.get(i).getStd());
                values.put("id_emp", cartera.get(i).getId_emp());
                values.put("nota_noApli", cartera.get(i).getNota_noApli());
                values.put("sald_fv", cartera.get(i).getSald_fv());
                values.put("prcs", cartera.get(i).getPrcs());

                db.insert("cartera", null, values);
            }
        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }

        db.close();
        return true;
    }

    public boolean insertContacto(List<ContactoSync> contacto) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        try {
            for (int i = 0; i < contacto.size(); i++){
                values.put("id_cnto", contacto.get(i).getId_cnto());
                values.put("id_emp", contacto.get(i).getId_emp());
                values.put("nmbr", contacto.get(i).getNmbr());
                values.put("dir", contacto.get(i).getDir());
                values.put("id_cdd", contacto.get(i).getId_cdd());
                values.put("tel", contacto.get(i).getTel());
                values.put("mail", contacto.get(i).getMail());
                values.put("pdt", contacto.get(i).getPdt());
                values.put("tipo", contacto.get(i).getTipo());
                values.put("prcs", contacto.get(i).getPrcs());

                db.insert("contacto", null, values);
            }
        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }

        db.close();
        return true;
    }

    public boolean insertEstadoCartera (List<EstadoCartera> estadoCarteras){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        try {
            for (int i = 0; i < estadoCarteras.size(); i++){
                values.put("code", estadoCarteras.get(i).getCode());
                values.put("description", estadoCarteras.get(i).getDescription());

                db.insert("estado_cartera", null, values);
            }
        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }

        db.close();
        return true;
    }

    //region Validar si el empleado existe.
    public boolean validateEmpleado(int data, String passwprd){
        boolean _validate = false;
        String sql_validate = "SELECT * FROM empleado_negocio WHERE id_empleado = "+data+" password="+passwprd;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql_validate, null);
        if (cursor.moveToFirst()) {
            _validate = true;
        }

        return _validate;
    }
    //endregion

    //region Validar si el empleado existe.
    public Empleado recuperarInfoEmpleado(){
        String sql_validate = "SELECT * FROM empleado_negocio LIMIT 1";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql_validate, null);

        Empleado empleado = new Empleado();

        if (cursor.moveToFirst()) {
            empleado.setNombre_empleado(cursor.getString(0));
            empleado.setId_empleado(Integer.parseInt(cursor.getString(1)));
            empleado.setPassword(cursor.getString(2));
        }

        return empleado;
    }
    //endregion

    public boolean DeleteEmpleado(){
        SQLiteDatabase db = this.getWritableDatabase();
        int p = db.delete("empleado_negocio", null, null);
        db.close();
        return p > 0;
    }

    //region Insertar La configuracion del empleado.
    public boolean insertConfiguracionEmple(List<Configuraciones> data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        for(int i = 0; i < data.size(); i++) {
            try {
                values.put("valor",data.get(i).getValor());
                values.put("variable",data.get(i).getVariable());

                db.insert("configuracion_emple", null, values);

            }catch (SQLiteConstraintException e){
                db.close();
                return false;
            }
        }

        db.close();
        return true;
    }
    //endregion

    //region Insertar Almacenes del empleado.
    public boolean insertAlmacenEmple(List<Almacenes> data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        for(int i = 0; i < data.size(); i++) {
            try {
                values.put("descripcion", data.get(i).getDescripcion());
                values.put("id", data.get(i).getId());
                values.put("prd", data.get(i).getPrd());

                db.insert("almacen_emple", null, values);

            } catch (SQLiteConstraintException e) {
                db.close();
                return false;
            }
        }

        db.close();
        return true;
    }
    //endregion

    //region Insertar Agencias de los Empleados.
    public boolean insertAgenciaEmple(List<Agencia> data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        for(int i = 0; i < data.size(); i++) {
            try {
                values.put("Id", data.get(i).getId());
                db.insert("agencia_emple", null, values);
            }catch (SQLiteConstraintException e){
                db.close();
                return false;
            }
        }

        db.close();
        return true;
    }
    //endregion

    //region Recuperar si ya tengo agencias en la bd
    public String selectAgenciasEmp(int data){

        boolean _id = false;
        boolean _validate = false;

        String sql = "SELECT * FROM agencia_emple";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.getCount() > 0) {
            // Se que encontro datos
            _validate = true;

            String sql_validate = "SELECT * FROM agencia_emple WHERE Id = "+data;
            Cursor cursor_validate = db.rawQuery(sql_validate, null);

            if (cursor_validate.getCount() > 0) {
                // la sede existe
                _id = true;
                _validate = false;
            }

        }

        if (_validate){
            return "1";
        } else if (_id) {
            return "2";
        } else {
            return "3";
        }

    }
    //endregion

    //region Insertar parametro al inicio de la aplicacion
    public boolean insertIP(String data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        try {
            values.put("ip", data);
            db.insert("ipselect", null, values);
        }catch (SQLiteConstraintException e){
            Log.d("ipselect", "failure to insert word,", e);
            return false;
        }
        return true;
    }
    //endregion

    //region Insertar negocios
    public boolean insertNegocio(LoginResponce data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        try {
            values.put("CodigoNegocio",data.getCodigoNegocio());
            values.put("Negocio",data.getNegocio());
            values.put("UrlImg",data.getUrlImg());
            db.insert("negocio", null, values);

            insertAgencias(data.getListAgencia());
            insertips(data.getListIp());

        }catch (SQLiteConstraintException e){
            db.close();
            return false;
        }

        db.close();
        return true;
    }
    //endregion

    //region Insertar Agencias..
    public boolean insertAgencias(List<ListAgencia> data){

        if(data != null && data.size() > 0){
            ContentValues valueAdicion = new ContentValues();
            SQLiteDatabase db = this.getWritableDatabase();
            int idNegocio = ultimoRegistro("negocio");

            for(int f = 0; f < data.size(); f++) {
                try {
                    valueAdicion.put("key", data.get(f).getKey());
                    valueAdicion.put("value", data.get(f).getValue());
                    valueAdicion.put("idnegocio", idNegocio);

                    db.insert("agencia", null, valueAdicion);

                }catch (SQLiteConstraintException e){
                    db.close();
                    return false;
                }
            }
        }

        return true;
    }
    //endregion

    //region Insertar ips..
    public boolean insertips(List<ListIp> data){

        if(data != null && data.size() > 0){
            ContentValues valueAdicion = new ContentValues();
            SQLiteDatabase db = this.getWritableDatabase();
            int idNegocio = ultimoRegistro("negocio");

            for(int i = 0; i < data.size(); i++) {
                try {
                    valueAdicion.put("key", data.get(i).getKey());
                    valueAdicion.put("value", data.get(i).getValue());
                    valueAdicion.put("idnegocio", idNegocio);

                    db.insert("ip", null, valueAdicion);

                }catch (SQLiteConstraintException e){
                    db.close();
                    return false;
                }
            }
        }

        return true;
    }
    //endregion

    //region Recuperar ultimo Registro
    public int ultimoRegistro(String table){
        int _id = 0;
        String sql = "SELECT CodigoNegocio FROM "+ table +" ORDER BY CodigoNegocio DESC LIMIT 1";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                _id = Integer.parseInt(cursor.getString(0));
            } while(cursor.moveToNext());
        }
        return _id;
    }
    //endregion

    //region Validar si ya existe el Negocio.
    public boolean validarNegocio(String data){

        boolean _id = false;

        String sql = "SELECT CodigoNegocio FROM negocio WHERE CodigoNegocio = "+data+" LIMIT 1";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                _id = true;
            } while(cursor.moveToNext());
        }
        return _id;
    }
    //endregion

    //region Validar Incio de sesion de la apliacion por primera ves
    public boolean getIntro(){
        Cursor cursor;
        boolean indicador = false;
        String sql = "SELECT * FROM intro LIMIT 1";
        SQLiteDatabase db = this.getWritableDatabase();
        cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            indicador = true;
        }
        return indicador;
    }
    //endregion

    public List<LoginResponce> selectNegocios(){

        ArrayList<LoginResponce> listNegocio = new ArrayList<>();

        String sql = "SELECT * FROM negocio ORDER BY CodigoNegocio ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {

            LoginResponce loginResponce = new LoginResponce();

            do {

                loginResponce.setCodigoNegocio(cursor.getString(0));
                loginResponce.setNegocio(cursor.getString(1));
                loginResponce.setUrlImg(cursor.getString(2));
                loginResponce.setListAgencia(listAgencias(cursor.getString(0)));
                loginResponce.setListIp(listIps(cursor.getString(0)));

                listNegocio.add(loginResponce);
            } while(cursor.moveToNext());
        }

        return listNegocio;

    }

    public List<Frecuencia> selectFrecuencia() {

        ArrayList<Frecuencia> frecuenciaArrayList = new ArrayList<>();

        String sql = "SELECT * FROM Frecuenciatb ORDER BY Description ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            Frecuencia frecuencia;
            do {
                frecuencia = new Frecuencia();
                frecuencia.setCode(cursor.getInt(1));
                frecuencia.setDescription(cursor.getString(2));

                frecuenciaArrayList.add(frecuencia);
            } while(cursor.moveToNext());
        }

        return frecuenciaArrayList;
    }

    public List<ListIp> listIps(String idNegocio){
        ArrayList<ListIp> listIps = new ArrayList<>();
        String sql = "SELECT key, value FROM ip WHERE idnegocio = "+idNegocio+" ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {

            do {
                ListIp listIp = new ListIp();
                listIp.setKey(cursor.getString(0));
                listIp.setValue(cursor.getString(1));

                listIps.add(listIp);
            } while(cursor.moveToNext());
        }

        return listIps;
    }

    public List<ListAgencia> listAgencias(String idNegocio){
        ArrayList<ListAgencia> listAgencias = new ArrayList<>();
        String sql = "SELECT * FROM agencia WHERE idnegocio = "+idNegocio+" ORDER BY value ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {

            do {
                ListAgencia listAgencia = new ListAgencia();
                listAgencia.setKey(cursor.getString(0));
                listAgencia.setValue(cursor.getString(1));
                listAgencia.setIdNegocio(cursor.getString(2));

                listAgencias.add(listAgencia);
            } while(cursor.moveToNext());
        }

        return listAgencias;
    }

    public List<ZonaSync> selectZona() {

        ArrayList<ZonaSync> zonaSyncArrayList = new ArrayList<>();

        String sql = "SELECT * FROM ZonaSync ORDER BY Descripcion ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            ZonaSync zonaSync;
            do {
                zonaSync = new ZonaSync();
                zonaSync.setId_zona(cursor.getInt(1));
                zonaSync.setDescripcion(cursor.getString(2));

                zonaSyncArrayList.add(zonaSync);
            } while(cursor.moveToNext());
        }

        return zonaSyncArrayList;
    }

    public List<CanalSync> selectCanal() {

        ArrayList<CanalSync> canalSyncArrayList = new ArrayList<>();

        String sql = "SELECT * FROM CanalSync ORDER BY Descripcion ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            CanalSync canalSync;
            do {
                canalSync = new CanalSync();
                canalSync.setId_canal(cursor.getInt(1));
                canalSync.setDescripcion(cursor.getString(2));

                canalSyncArrayList.add(canalSync);
            } while(cursor.moveToNext());
        }

        return canalSyncArrayList;
    }

}
