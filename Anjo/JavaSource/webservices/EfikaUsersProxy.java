package webservices;

public class EfikaUsersProxy implements webservices.EfikaUsers_PortType {
  private String _endpoint = null;
  private webservices.EfikaUsers_PortType efikaUsers_PortType = null;
  
  public EfikaUsersProxy() {
    _initEfikaUsersProxy();
  }
  
  public EfikaUsersProxy(String endpoint) {
    _endpoint = endpoint;
    _initEfikaUsersProxy();
  }
  
  private void _initEfikaUsersProxy() {
    try {
      efikaUsers_PortType = (new webservices.EfikaUsers_ServiceLocator()).get_8();
      if (efikaUsers_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)efikaUsers_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)efikaUsers_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (efikaUsers_PortType != null)
      ((javax.xml.rpc.Stub)efikaUsers_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webservices.EfikaUsers_PortType getEfikaUsers_PortType() {
    if (efikaUsers_PortType == null)
      _initEfikaUsersProxy();
    return efikaUsers_PortType;
  }
  
  public java.lang.Boolean autenticarUsuario(java.lang.String login, java.lang.String senha) throws java.rmi.RemoteException{
    if (efikaUsers_PortType == null)
      _initEfikaUsersProxy();
    return efikaUsers_PortType.autenticarUsuario(login, senha);
  }
  
  public webservices.Usuario consultarUsuario(java.lang.String login) throws java.rmi.RemoteException{
    if (efikaUsers_PortType == null)
      _initEfikaUsersProxy();
    return efikaUsers_PortType.consultarUsuario(login);
  }
  
  
}