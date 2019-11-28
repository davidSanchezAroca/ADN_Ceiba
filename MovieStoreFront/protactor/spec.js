// spec.js

describe('Prueba flujo principal', function() {
    it('should have a title', function() {
      browser.get('http://localhost:4200/');
      console.log(browser.getTitle());
      expect(browser.getTitle()).toEqual('MovieStore');
    });
  });

 
  describe('Boton nuevo usuario', function() {
    it('boton usuario', function() {
      browser.get('http://localhost:4200/');
      element(by.id('crearCliente')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/cliente-form'); 
    });
  });


  describe('Creacion usuario', function() {
    it('creacion nueva usuario', function() {
      browser.get('http://localhost:4200/cliente-form');
      element(by.id('cedula')).sendKeys(123);
      element(by.id('nombre')).sendKeys("juan");
      element(by.id('apellido')).sendKeys("sanchez");
      element(by.id('fechaNacimiento')).sendKeys("2012-02-12");
      element(by.id('botonCrearUsuario')).click();
      element(by.buttonText('OK')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/movie-store'); 
    });
  });

  describe('Creacion pelicula', function() {
    it('creacion nueva pelicula', function() {
      browser.get('http://localhost:4200/pelicula-form');
      element(by.id('name')).sendKeys("destino final");
      element(by.id('valor')).sendKeys(50);
      element(by.id('botonCrearPelicula')).click();
      element(by.buttonText('OK')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/movie-store'); 
    });
  });

 
  describe('Boton nueva pelicula', function() {
    it('crear pelicula', function() {
      browser.get('http://localhost:4200/');
      element(by.id('CrearPelicula')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/pelicula-form'); 
    });
  });

  describe('Boton calcular precio', function() {
    it('boton precio', function() {
      browser.get('http://localhost:4200/listar-orden-form');
      element(by.id('cedula')).sendKeys(123);
      element(by.buttonText('listar')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/listar-orden-form');
    });
  });


  describe('crear orden', function(){
    it('crear orden',function(){
      browser.get('http://localhost:4200/orden-form');
      element(by.id('fechaOrden')).sendKeys("2012-02-12");
      element(by.id('fechaInicio')).sendKeys("2012-02-12");
      element(by.id('fechaFin')).sendKeys("2012-02-12");
      element(by.id('cedula')).sendKeys(123);
      element(by.id('botonCrearOrden')).click();
      element(by.buttonText('OK')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/movie-store');
    });
  });

  describe('Asociar pelicula orden', function(){
    it('Asociar pelicula orden',function(){
      browser.get('http://localhost:4200/listar-pelicula-form');
      element(by.id('nombre')).sendKeys("destino final");
      element(by.id('orden')).sendKeys(1);
      element(by.id('botonAgregarpeliculaorden')).click();
      element(by.buttonText('OK')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/movie-store');
    });
  });