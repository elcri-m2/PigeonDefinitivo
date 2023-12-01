package com.example.myapplication.modelView;

import com.example.myapplication.Model.LlamarDatosFirebase;
import com.example.myapplication.Model.SubirDatosFirebase;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class MetodosFirebaseAplicacion {
    /*
     Métodos para obtener los datos del usuario de forma asíncrona
     En esta clase se obtendran todos los Listener debido a que, como es una
     consulta a firebase no retorna los datos de forma sincronica al proceso
     de ejecucion de la aplicacion. Es por eso que es necesario este conjunto
     de metodos , ya que sin estos los datos pedidos a firebase retornaran NUll
     */
    LlamarDatosFirebase Obtener= new LlamarDatosFirebase();
    SubirDatosFirebase O= new SubirDatosFirebase();
    public Task<String> PaisAsin() {
        final TaskCompletionSource<String> taskpais = new TaskCompletionSource<>();
        Obtener.datosUsuario(new LlamarDatosFirebase.OnDatosUsuarioObtainedListener() {
            @Override
            public void onPaisObtained(String pais) {
                taskpais.setResult(pais);
            }@Override public void onGeneroObtained(String genero) {}@Override public void onTipoUsurioObtained(String pais) {}@Override public void onUIDObtained(String pais){}@Override public void onNombreObtained(String pais){}@Override public void onFotoObtained(String foto){}});
        return taskpais.getTask();
    }
    public Task<String> GeneroAsin() {
        final TaskCompletionSource<String> taskgenero = new TaskCompletionSource<>();
        Obtener.datosUsuario(new LlamarDatosFirebase.OnDatosUsuarioObtainedListener() {
            @Override
            public void onGeneroObtained(String genero) {
                taskgenero.setResult(genero);
            }@Override public void onPaisObtained(String genero) {}@Override public void onTipoUsurioObtained(String pais) {}@Override public void onUIDObtained(String pais) {}@Override public void onNombreObtained(String pais) {}@Override public void onFotoObtained(String foto) {}});
        return taskgenero.getTask();
    }
    public Task<String> NombreAsin() {
        final TaskCompletionSource<String> tasknombre = new TaskCompletionSource<>();
        Obtener.datosUsuario(new LlamarDatosFirebase.OnDatosUsuarioObtainedListener() {
            @Override
            public void onNombreObtained(String nombre) {
                tasknombre.setResult(nombre);
            }@Override
            public void onFotoObtained(String foto){}@Override public void onGeneroObtained(String g) {}@Override public void onTipoUsurioObtained(String c){}@Override public void onUIDObtained(String pais) {}@Override public void onPaisObtained(String p) {}});
        return tasknombre.getTask();
    }
    public Task<String> TipoUsuarioAsin() {
        final TaskCompletionSource<String> taskTipoUsuario = new TaskCompletionSource<>();
        Obtener.datosUsuario(new LlamarDatosFirebase.OnDatosUsuarioObtainedListener() {
            @Override
            public void onTipoUsurioObtained(String TipoUsuario) {
                taskTipoUsuario.setResult(TipoUsuario);
            }
            @Override
            public void onUIDObtained(String pais){}@Override public void onGeneroObtained(String g){}@Override public void onNombreObtained(String c){}@Override public void onFotoObtained(String foto){}@Override public void onPaisObtained(String p) {}});
        return taskTipoUsuario.getTask();
    }
    public Task<String> FotoAsin() {
        final TaskCompletionSource<String> taskFoto = new TaskCompletionSource<>();
        Obtener.datosUsuario(new LlamarDatosFirebase.OnDatosUsuarioObtainedListener() {
            @Override
            public void onFotoObtained(String Foto) {
                taskFoto.setResult(Foto);
            }@Override public void onGeneroObtained(String g){}@Override public void onNombreObtained(String c){}@Override public void onTipoUsurioObtained(String foto){}@Override public void onUIDObtained(String pais){}@Override public void onPaisObtained(String p) {}});
        return taskFoto.getTask();
    }
    public Task<String> UIDCAsin() {
        final TaskCompletionSource<String> taskUID = new TaskCompletionSource<>();
        Obtener.datosUsuario(new LlamarDatosFirebase.OnDatosUsuarioObtainedListener() {
            @Override
            public void onUIDObtained(String UID) {
                taskUID.setResult(UID);
            }@Override public void onGeneroObtained(String g){}@Override public void onNombreObtained(String c){}@Override public void onTipoUsurioObtained(String foto){}@Override public void onFotoObtained(String pais){}@Override public void onPaisObtained(String p) {}});
        return taskUID.getTask();
    }


    public Task<String> PaisAsinC() {
        final TaskCompletionSource<String> task = new TaskCompletionSource<>();
        Obtener.datosConsultar(new LlamarDatosFirebase.OnDatosConsultarObtainedListener() {
            @Override
            public void onPaisObtained(String pais) {
                task.setResult(pais);}
            @Override public void onGeneroObtained(String pais){}@Override public void onTipoUsurioObtained(String pais){}@Override public void onUIDObtained(String pais) {}@Override public void onNombreObtained(String pais){}@Override public void onFotoObtained(String foto){}

            @Override
            public void onCorreoObtained(String foto) {

            }

            @Override
            public void onPuntuacionObtained(String foto) {

            }

            @Override
            public void onNumPunObtained(String foto) {

            }

            @Override
            public void onComentarioObtained(String foto) {

            }
        });
        return task.getTask();
    }
    public Task<String> GeneroAsinC() {
        final TaskCompletionSource<String> taskgenero = new TaskCompletionSource<>();
        Obtener.datosConsultar(new LlamarDatosFirebase.OnDatosConsultarObtainedListener() {
            @Override
            public void onGeneroObtained(String genero) {
                taskgenero.setResult(genero);
            }@Override public void onPaisObtained(String genero) {}@Override public void onTipoUsurioObtained(String pais) {}@Override public void onUIDObtained(String pais) {}@Override public void onNombreObtained(String pais) {}@Override public void onFotoObtained(String foto) {}

            @Override
            public void onCorreoObtained(String foto) {

            }

            @Override
            public void onPuntuacionObtained(String foto) {

            }

            @Override
            public void onNumPunObtained(String foto) {

            }

            @Override
            public void onComentarioObtained(String foto) {

            }
        });
        return taskgenero.getTask();
    }
    public Task<String> NombreAsinC() {
        final TaskCompletionSource<String> tasknombre = new TaskCompletionSource<>();
        Obtener.datosConsultar(new LlamarDatosFirebase.OnDatosConsultarObtainedListener() {
            @Override
            public void onNombreObtained(String nombre) {
                tasknombre.setResult(nombre);
            }@Override
            public void onFotoObtained(String foto){}

            @Override
            public void onCorreoObtained(String foto) {

            }

            @Override
            public void onPuntuacionObtained(String foto) {

            }

            @Override
            public void onNumPunObtained(String foto) {

            }

            @Override
            public void onComentarioObtained(String foto) {

            }

            @Override public void onGeneroObtained(String g) {}@Override public void onTipoUsurioObtained(String c){}@Override public void onUIDObtained(String pais) {}@Override public void onPaisObtained(String p) {}});
        return tasknombre.getTask();
    }
    public Task<String> TipoUsuarioAsinC() {
        final TaskCompletionSource<String> taskTipoUsuario = new TaskCompletionSource<>();
        Obtener.datosConsultar(new LlamarDatosFirebase.OnDatosConsultarObtainedListener() {
            @Override
            public void onTipoUsurioObtained(String TipoUsuario) {
                taskTipoUsuario.setResult(TipoUsuario);
            }@Override public void onUIDObtained(String pais){}@Override public void onGeneroObtained(String g){}@Override public void onNombreObtained(String c){}@Override public void onFotoObtained(String foto){}@Override public void onCorreoObtained(String foto){}

            @Override
            public void onPuntuacionObtained(String foto) {

            }

            @Override
            public void onNumPunObtained(String foto) {

            }

            @Override
            public void onComentarioObtained(String foto) {

            }
            @Override public void onPaisObtained(String p) {}});
        return taskTipoUsuario.getTask();
    }public Task<String> CorreoAsinC() {
        final TaskCompletionSource<String> taskCorreo = new TaskCompletionSource<>();
        Obtener.datosConsultar(new LlamarDatosFirebase.OnDatosConsultarObtainedListener() {
            @Override
            public void onCorreoObtained(String Correo) {
                taskCorreo.setResult(Correo);
            }

            @Override
            public void onPuntuacionObtained(String foto) {

            }

            @Override
            public void onNumPunObtained(String foto) {

            }

            @Override
            public void onComentarioObtained(String foto) {

            }
            @Override public void onUIDObtained(String pais){}@Override public void onGeneroObtained(String g){}@Override public void onNombreObtained(String c){}@Override public void onFotoObtained(String foto){}@Override public void onTipoUsurioObtained(String foto){}@Override public void onPaisObtained(String p) {}});
        return taskCorreo.getTask();
    }
    public Task<String> FotoAsinC() {
        final TaskCompletionSource<String> taskFoto = new TaskCompletionSource<>();
        Obtener.datosConsultar(new LlamarDatosFirebase.OnDatosConsultarObtainedListener() {
            @Override public void onFotoObtained(String Foto) {
                taskFoto.setResult(Foto);
            }@Override public void onCorreoObtained(String foto){}@Override public void onPuntuacionObtained(String foto){}@Override public void onNumPunObtained(String foto){}

            @Override
            public void onComentarioObtained(String foto) {

            }
            @Override public void onGeneroObtained(String g){}@Override public void onNombreObtained(String c){}@Override public void onTipoUsurioObtained(String foto){}@Override public void onUIDObtained(String pais){}@Override public void onPaisObtained(String p) {}});
        return taskFoto.getTask();
    }
    public Task<String> UIDCAsinC() {
        final TaskCompletionSource<String> taskUID = new TaskCompletionSource<>();
        Obtener.datosConsultar(new LlamarDatosFirebase.OnDatosConsultarObtainedListener() {
            @Override
            public void onUIDObtained(String UID) {
                taskUID.setResult(UID);
            }@Override public void onGeneroObtained(String g){}@Override public void onNombreObtained(String c){}@Override public void onTipoUsurioObtained(String foto){}@Override public void onFotoObtained(String pais){}@Override public void onCorreoObtained(String foto){}@Override public void onPuntuacionObtained(String foto){}@Override public void onNumPunObtained(String foto){}

            @Override
            public void onComentarioObtained(String foto) {

            }
            @Override public void onPaisObtained(String p) {}});
        return taskUID.getTask();
    }
    public Task<String> ComentarioAsinC() {
        final TaskCompletionSource<String> task = new TaskCompletionSource<>();
        Obtener.datosConsultar(new LlamarDatosFirebase.OnDatosConsultarObtainedListener() {
            @Override
            public void onComentarioObtained(String pais) {
                task.setResult(pais);}
            @Override public void onGeneroObtained(String pais){}@Override public void onTipoUsurioObtained(String pais){}@Override public void onUIDObtained(String pais) {}@Override public void onNombreObtained(String pais){}@Override public void onFotoObtained(String foto){}

            @Override
            public void onCorreoObtained(String foto) {

            }

            @Override
            public void onPuntuacionObtained(String foto) {

            }

            @Override
            public void onNumPunObtained(String foto) {

            }

            @Override
            public void onPaisObtained(String foto) {

            }
        });
        return task.getTask();
    }

    public Task<String> PuntuacionAsinC() {
        final TaskCompletionSource<String> task = new TaskCompletionSource<>();
        Obtener.datosConsultar(new LlamarDatosFirebase.OnDatosConsultarObtainedListener() {
            @Override
            public void onPuntuacionObtained(String U) {
                task.setResult(U);
            }@Override public void onGeneroObtained(String g){}@Override public void onNombreObtained(String c){}@Override public void onTipoUsurioObtained(String foto){}@Override public void onFotoObtained(String pais){}@Override public void onCorreoObtained(String foto){}@Override public void onUIDObtained(String foto) {}@Override public void onNumPunObtained(String foto){}

            @Override
            public void onComentarioObtained(String foto) {

            }

            @Override public void onPaisObtained(String p) {}});
        return task.getTask();
    }
    public Task<String> NumPunAsinC() {
        final TaskCompletionSource<String> task = new TaskCompletionSource<>();
        Obtener.datosConsultar(new LlamarDatosFirebase.OnDatosConsultarObtainedListener() {
            @Override
            public void onNumPunObtained(String Num) {
                task.setResult(Num);
            }

            @Override
            public void onComentarioObtained(String foto) {

            }

            @Override public void onGeneroObtained(String g){}@Override public void onNombreObtained(String c){}@Override public void onTipoUsurioObtained(String foto){}@Override public void onFotoObtained(String pais){}@Override public void onCorreoObtained(String foto) {}@Override public void onPuntuacionObtained(String foto) {}@Override public void onUIDObtained(String foto) {}@Override public void onPaisObtained(String p) {}});
        return task.getTask();
    }
    public Task<String> NombreNoticiaAsin() {
        final TaskCompletionSource<String> taskNombreNoticia = new TaskCompletionSource<>();
        Obtener.Noticia(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void onNombreNoticiaObtained(String NombreNoticia) {
                taskNombreNoticia.setResult(NombreNoticia);
            }@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskNombreNoticia.getTask();
    }
    public Task<String> NoticiaAsin() {
        final TaskCompletionSource<String> taskNoticia = new TaskCompletionSource<>();
        Obtener.Noticia(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void onNoticiaObtained(String Noticia) {
                taskNoticia.setResult(Noticia);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskNoticia.getTask();
    }
    public Task<String> LinkAsin() {
        final TaskCompletionSource<String> taskLink = new TaskCompletionSource<>();
        Obtener.Noticia(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onLinkObtained(String Link) {
                taskLink.setResult(Link);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskLink.getTask();
    }
    public Task<String> ImagenAsin() {
        final TaskCompletionSource<String> taskImagen = new TaskCompletionSource<>();
        Obtener.Noticia(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onImagenObtained (String Imagen) {
                taskImagen.setResult(Imagen);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskImagen.getTask();
    }
    public Task<String> PaisNAsin() {
        final TaskCompletionSource<String> taskPais = new TaskCompletionSource<>();
        Obtener.Noticia(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onPaisObtained  (String Pais) {
                taskPais.setResult(Pais);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskPais.getTask();
    }
    public Task<String> UIDAsin() {
        final TaskCompletionSource<String> taskUID = new TaskCompletionSource<>();
        Obtener.Noticia(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onUIDObtained (String UID) {
                taskUID.setResult(UID);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskUID.getTask();
    }
    public Task<String> PaisOrigenAsin() {
        final TaskCompletionSource<String> taskPaisOrigen = new TaskCompletionSource<>();
        Obtener.Noticia(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onPaisOrigenObtained (String PaisOrigen) {
                taskPaisOrigen.setResult(PaisOrigen);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskPaisOrigen.getTask();
    }
    public Task<String> fechaAsin() {
        final TaskCompletionSource<String> taskfecha = new TaskCompletionSource<>();
        Obtener.Noticia(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onfechaObtained (String fecha) {
                taskfecha.setResult(fecha);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskfecha.getTask();
    }
    public Task<String> VideoAsin() {
        final TaskCompletionSource<String> taskVideo = new TaskCompletionSource<>();
        Obtener.Noticia(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onVideoObtained (String Link) {
                taskVideo.setResult(Link);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskVideo.getTask();
    }
    public Task<String> TipoNoticiaAsin() {
        final TaskCompletionSource<String> taskTipoNoticia = new TaskCompletionSource<>();
        Obtener.Noticia(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onTipoNoticiaObtained (String Link) {
                taskTipoNoticia.setResult(Link);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onVideoObtained(String pais){}});
        return taskTipoNoticia.getTask();
    }


    public Task<String> NombreNoticiaAsinS() {
        final TaskCompletionSource<String> taskNombreNoticia = new TaskCompletionSource<>();
        Obtener.NoticiasSeguir(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void onNombreNoticiaObtained(String NombreNoticia) {
                taskNombreNoticia.setResult(NombreNoticia);
            }@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskNombreNoticia.getTask();
    }
    public Task<String> NoticiaAsinS() {
        final TaskCompletionSource<String> taskNoticia = new TaskCompletionSource<>();
        Obtener.NoticiasSeguir(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void onNoticiaObtained(String Noticia) {
                taskNoticia.setResult(Noticia);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskNoticia.getTask();
    }
    public Task<String> LinkAsinS() {
        final TaskCompletionSource<String> taskLink = new TaskCompletionSource<>();
        Obtener.NoticiasSeguir(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onLinkObtained(String Link) {
                taskLink.setResult(Link);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskLink.getTask();
    }
    public Task<String> ImagenAsinS() {
        final TaskCompletionSource<String> taskImagen = new TaskCompletionSource<>();
        Obtener.NoticiasSeguir(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onImagenObtained (String Imagen) {
                taskImagen.setResult(Imagen);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskImagen.getTask();
    }
    public Task<String> PaisNAsinS() {
        final TaskCompletionSource<String> taskPais = new TaskCompletionSource<>();
        Obtener.NoticiasSeguir(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onPaisObtained  (String Pais) {
                taskPais.setResult(Pais);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskPais.getTask();
    }
    public Task<String> UIDAsinS() {
        final TaskCompletionSource<String> taskUID = new TaskCompletionSource<>();
        Obtener.NoticiasSeguir(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onUIDObtained (String UID) {
                taskUID.setResult(UID);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskUID.getTask();
    }
    public Task<String> PaisOrigenAsinS() {
        final TaskCompletionSource<String> taskPaisOrigen = new TaskCompletionSource<>();
        Obtener.NoticiasSeguir(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onPaisOrigenObtained (String PaisOrigen) {
                taskPaisOrigen.setResult(PaisOrigen);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskPaisOrigen.getTask();
    }
    public Task<String> fechaAsinS() {
        final TaskCompletionSource<String> taskfecha = new TaskCompletionSource<>();
        Obtener.NoticiasSeguir(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onfechaObtained (String fecha) {
                taskfecha.setResult(fecha);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onVideoObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskfecha.getTask();
    }
    public Task<String> VideoAsinS() {
        final TaskCompletionSource<String> taskVideo = new TaskCompletionSource<>();
        Obtener.NoticiasSeguir(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onVideoObtained (String Link) {
                taskVideo.setResult(Link);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onTipoNoticiaObtained(String pais){}});
        return taskVideo.getTask();
    }
    public Task<String> TipoNoticiaAsinS() {
        final TaskCompletionSource<String> taskTipoNoticia = new TaskCompletionSource<>();
        Obtener.NoticiasSeguir(new LlamarDatosFirebase.OnNotciaObtainedListener() {
            @Override
            public void  onTipoNoticiaObtained (String Link) {
                taskTipoNoticia.setResult(Link);
            }@Override public void onNombreNoticiaObtained(String pais){}@Override public void onNoticiaObtained(String pais){}@Override public void onLinkObtained(String pais){}@Override public void onPaisObtained(String pais){}@Override public void onUIDObtained(String pais){}@Override public void onPaisOrigenObtained(String pais){}@Override public void onfechaObtained(String pais){}@Override public void onImagenObtained(String pais){}@Override public void onVideoObtained(String pais){}});
        return taskTipoNoticia.getTask();
    }




    public Task<String> SizeBAsin() {
        final TaskCompletionSource<String> task = new TaskCompletionSource<>();
        O.Tamano(new SubirDatosFirebase.OnTamanoObtainedListener() {
            @Override
            public void onSizeBObtained(String L) {
                task.setResult(L);
            }@Override public void onSizeNObtained(String pais) {}@Override public void onSizeMObtained(String pais) {}@Override public void onSizeEObtained(String pais) {}{}});
        return task.getTask();
    }
    public Task<String> SizeNAsin() {
        final TaskCompletionSource<String> task = new TaskCompletionSource<>();
        O.Tamano(new SubirDatosFirebase.OnTamanoObtainedListener() {
            @Override
            public void onSizeNObtained(String L) {
                task.setResult(L);
            }@Override public void onSizeBObtained(String pais) {}@Override public void onSizeMObtained(String pais) {}@Override public void onSizeEObtained(String pais) {}{}});
        return task.getTask();
    }
    public Task<String> SizeMAsin() {
        final TaskCompletionSource<String> task = new TaskCompletionSource<>();
        O.Tamano(new SubirDatosFirebase.OnTamanoObtainedListener() {
            @Override
            public void onSizeMObtained(String L) {
                task.setResult(L);
            }@Override public void onSizeNObtained(String pais) {}@Override public void onSizeBObtained(String pais) {}@Override public void onSizeEObtained(String pais) {}{}});
        return task.getTask();
    }
    public Task<String> SizeEAsin() {
        final TaskCompletionSource<String> task = new TaskCompletionSource<>();
        O.Tamano(new SubirDatosFirebase.OnTamanoObtainedListener() {
            @Override
            public void onSizeEObtained(String L) {
                task.setResult(L);
            }@Override public void onSizeNObtained(String pais) {}@Override public void onSizeMObtained(String pais) {}@Override public void onSizeBObtained(String pais) {}{}});
        return task.getTask();
    }
}
