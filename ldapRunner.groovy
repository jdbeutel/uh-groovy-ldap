import javax.naming.directory.DirContext
import javax.naming.directory.InitialDirContext

import static javax.naming.Context.*

Hashtable env = [
        (INITIAL_CONTEXT_FACTORY): 'com.sun.jndi.ldap.LdapCtxFactory',
        (PROVIDER_URL)           : 'ldaps://ldap.hawaii.edu:636',
        (SECURITY_PRINCIPAL)     : 'cn=filedrop,ou=Specials,dc=hawaii,dc=edu',
        (SECURITY_CREDENTIALS)   : ''   // <--- Your password goes here.
]

def ctx = new InitialDirContext(env)
try {
    println 'vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv'
    def people = args.collect { search(ctx, it) }
    println people.join('\n    ....................................\n')
    println '^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^'
} finally {
    ctx.close()
}

String search(DirContext ctx, uid) {
    def base = 'ou=people,dc=hawaii,dc=edu'
    String filter = "(uid=$uid)"
    def results = null
    try {
        results = ctx.search(base, filter, null)
        results.collect { entry ->
            def attributes = ['cn', 'uid', 'uhUuid', 'mail']
            attributes.collect { entry.attributes.get(it) }
        }.join('\n')
    } finally {
        results?.close()
    }
}
