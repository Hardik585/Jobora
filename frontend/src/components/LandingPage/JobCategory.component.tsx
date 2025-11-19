import { Carousel } from "@mantine/carousel";
import { jobCategory } from "../../Data/Data";
import { IconArrowLeft, IconArrowRight } from "@tabler/icons-react";

const JobCategory = () => {
    return (
        <div className="mt-20 pb-5">
            <div className="text-4xl text-center font-semibold mb-3 text-mine-shaft-100 [&>span]:text-emerald-400">
                Browse <span>Job</span> Category
            </div>
            <div className="text-lg text-mine-shaft-100  text-center w-1/2 mx-auto mb-15">Explore diverse job Opportunities tailored to your skills. Start your career journey Today!
            </div>
            <Carousel slideSize="22%" slideGap="xs" emblaOptions={{ loop: true }}
                nextControlIcon={<IconArrowRight className="w-8 h-8" />}
                previousControlIcon={<IconArrowLeft className="w-8 h-8" />}
                classNames={{
                    root: "group", // enables hover for the whole carousel
                    controls: "opacity-0 group-hover:opacity-100 transition-opacity",
                    control: "!bg-emerald-400 !border-none hover:opacity-75"
                }}
            >
                {
                    jobCategory.map((category, index) => <Carousel.Slide key={index}>
                        <div className="flex flex-col items-center w-64 gap-2 border rounded-lg p-5 border-emerald-400 hover:cursor-pointer hover:shadow-[0_0_5px_2px_black] !shadow-emerald-400 my-5 transition duration-400 ease-in-out">
                            <div className="p-2 bg-emerald-300 rounded-full">
                                <img className="h-8 w-8" src={`/Category/${category.name}.png`} alt={category.name} />
                            </div>
                            <div className="text-xl text-mine-shaft-50 font-semibold">{category.name}</div>
                            <div className="text-center text-mine-shaft-300 text-sm">{category.desc}</div>
                            <div className="text-lg text-emerald-400">{category.jobs}+ jobs posted</div>
                        </div>
                    </Carousel.Slide>)
                }
            </Carousel>

        </div>
    )
}

export default JobCategory;