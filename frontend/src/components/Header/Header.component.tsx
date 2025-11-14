

import { Avatar, Indicator } from "@mantine/core";
import { IconBell, IconDevicesDollar, IconSettings } from "@tabler/icons-react"
import NavLinks from "./NavLinks.component";

const Header = () => {
    return (
        <div className='bg-stone-800 text-white h-28 px-6 flex justify-between items-center'>
            <div className="flex  items-center text-emerald-400">
                <IconDevicesDollar stroke={1.5} className="w-15 h-15" />
                <span className="font-semibold text-2xl">Jobora</span>
            </div>
             {NavLinks()}
            <div className="flex gap-3 items-center-safe">
                <div className="flex gap-2 items-center">   
                    <div>Hardik</div>
                    <Avatar src="./images/avatar.png" alt="it's me" />
                </div>
                <div className="bg-stone-900 p-2 rounded-full"> <IconSettings stroke={1.5} /></div>
                <div className="bg-stone-900 p-2 rounded-full">
                    <Indicator color="green.5" size={10} offset={6} withBorder processing>
                        <IconBell stroke={1.5} />
                    </Indicator>
                </div>

            </div>
        </div >
    )
}

export default Header;