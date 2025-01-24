package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.core.dao.IUsuarioDao;
import cl.qande.mmii.app.models.db.core.entity.Role;
import cl.qande.mmii.app.models.db.core.entity.Usuario;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{

	private final IUsuarioDao usuarioDao;

	@Autowired
	public JpaUserDetailsService(IUsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }


    @Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        Usuario usuario = usuarioDao.findByUsername(username);
        
        if(usuario == null) {
			CustomLog.getInstance().error("Username: " + username + " no existe en el sistema!");
        	throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }
        
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        for(Role role: usuario.getRoles()) {
			CustomLog.getInstance().info("Role: "+role.getAuthority());
        	authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        
        if(authorities.isEmpty()) {
			CustomLog.getInstance().error("Error en el Login: Usuario '"+username+"' no tiene roles asignados!");
        	throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
        }
        
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

}
