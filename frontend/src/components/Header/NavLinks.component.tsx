import { Link, useLocation } from "react-router-dom";

const NavLinks = () => {
    const links = [
        { name: 'Find Jobs', url: 'find-jobs' },
        { name: 'Find Talents', url: 'find-talent' },
        { name: 'Upload Jobs', url: 'upload-jobs' },
        { name: 'About Us', url: 'about' }
    ];
    const location = useLocation();
    return (
        <div className="flex gap-5 text-mine-shaft-100 items-center h-full" >
            {
                links.map((link, index) =>
                    <div key={index} className={`${location.pathname == "/" + link.url ? "text-emerald-400 border-emerald-400" : "border-transparent"} border-t-[3px] h-full flex items-center`}>
                        <Link key={index} to={link.url}>{link.name}</Link>
                    </div>)
            }
        </div >
    )
}

export default NavLinks;